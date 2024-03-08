package com.santos.barberqueue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.repositories.ScheduleRepository;
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
		this.barberShopService.insertAll(schedule.getServices());
		this.barberService.insert(schedule.getBarber());
		this.customerService.insert(schedule.getCustomer());
		return repo.save(schedule);
	}

	@Transactional
	public Schedule update(Schedule schedule) {
		find(schedule.getId());
		this.barberShopService.update(schedule.getServices());
		this.barberService.update(schedule.getBarber());
		this.customerService.update(schedule.getCustomer());
		return repo.save(schedule);
	}
}
