package com.santos.barberqueue.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Barber;
import com.santos.barberqueue.dto.BarberDTO;
import com.santos.barberqueue.repositories.BarberRepository;
import com.santos.barberqueue.services.exceptions.DataIntegrityException;
import com.santos.barberqueue.services.exceptions.ObjectNotFoundException;

@Service
public class BarberService {
	@Autowired
	private BarberRepository repo;
	
	public Barber find(Integer id) {
		Optional<Barber> obj  = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object is not found, Id: " + id + ", Type: " + Barber.class.getName()));
	}
	
	public List<Barber> findAll() {
		List<Barber> obj = repo.findAll();
		return obj;
	}
	
	public Barber insert (Barber barber) {
		barber.setId(null);
		return repo.save(barber);
	}
	
	public Barber update(Barber newBarber) {
		Barber barber = find(newBarber.getId());
		try {
			updateData(barber, newBarber);
		} catch (IllegalAccessException e) {
			throw new DataIntegrityException("Não foi possível atualizar os dados");
		}
		return repo.save(newBarber);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Barber");
		}
	}
	
	public Barber toBarberFromDTO(BarberDTO dto) {
		return new Barber(dto.getId(), dto.getName(), dto.getCnpj(), dto.getEmail(), dto.getPassword());
	}

	private void updateData(Barber barber, Barber newBarber) throws IllegalAccessException {
		Field[] fields = Barber.class.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			Object sourceData = field.get(barber);
			Object targetData = field.get(newBarber);

			if (sourceData != null && targetData == null && !field.getName().equals("serialVersionUID")) {
				field.set(newBarber, sourceData);
			}
		}
	}
}
