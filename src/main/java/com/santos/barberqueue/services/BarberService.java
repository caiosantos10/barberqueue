package com.santos.barberqueue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Barber;
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
	
	public Barber update(Barber barber) {
		find(barber.getId());
		return repo.save(barber);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Barber");
		}
	}
}
