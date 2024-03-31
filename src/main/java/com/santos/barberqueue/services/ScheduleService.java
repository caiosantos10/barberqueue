package com.santos.barberqueue.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Barber;
import com.santos.barberqueue.domain.Customer;
import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.dto.ScheduleDTO;
import com.santos.barberqueue.repositories.ScheduleRepository;
import com.santos.barberqueue.services.exceptions.DataIntegrityException;
import com.santos.barberqueue.services.exceptions.ObjectNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository repo;

	@Autowired
	private BarberService barberService;
	@Autowired
	private BarberShopServiceService barberShopService;
	@Autowired
	private CustomerService customerService;

	public Schedule find(Integer id) {
		Optional<Schedule> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object is not found, Id: " + id + ", Type: " + Schedule.class.getName()));
	}

	public List<Schedule> findAll() {
		List<Schedule> obj = repo.findAll();
		return obj;
	}

	@Transactional
	public Schedule insert(Schedule schedule) {
		schedule.setId(null);
		
		this.customerService.find(schedule.getCustomer().getId());
		this.barberService.find(schedule.getBarber().getId());
		
		this.barberShopService.insertAll(schedule.getServices());
		return repo.save(schedule);
	}

	@Transactional
	public Schedule update(Schedule newSchedule) {
		Schedule schedule = find(newSchedule.getId());
		try {
			updateData(schedule, newSchedule);
		} catch (IllegalAccessException e) {
			throw new DataIntegrityException("Não foi possível atualizar os dados");
		}
		return repo.save(newSchedule);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Schedule");
		}
	}

	public Page<Schedule> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Schedule toScheduleFromDTO(ScheduleDTO dto) {
		Schedule schedule = new Schedule(dto.getId(), dto.getInitialTime(), dto.getEndTime(), null, null, dto.getIsActive());
		
		Customer customer = this.customerService.find(dto.getCustomerId());
		Barber barber = this.barberService.find(dto.getBarberId());
		
		schedule.setCustomer(customer);
		schedule.setBarber(barber);
		
		return schedule;
	}
	
	private void updateData(Schedule schedule, Schedule newSchedule) throws IllegalAccessException {
		Field[] fields = Schedule.class.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			Object sourceData = field.get(schedule);
			Object targetData = field.get(newSchedule);

			if (sourceData != null && targetData == null && !field.getName().equals("serialVersionUID")) {
				field.set(newSchedule, sourceData);
			}
		}
	}
}
