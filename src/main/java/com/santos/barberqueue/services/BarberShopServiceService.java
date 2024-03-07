package com.santos.barberqueue.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.BarberShopService;
import com.santos.barberqueue.repositories.BarberShopServiceRepository;
import com.santos.barberqueue.services.exceptions.ObjectNotFoundException;

@Service
public class BarberShopServiceService {
	@Autowired
	private BarberShopServiceRepository repo;
	
	public BarberShopService find(Integer id) {
		Optional<BarberShopService> obj  = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object is not found, Id: " + id + ", Type: " + BarberShopService.class.getName()));
	}
	
	public List<BarberShopService> insertAll(List<BarberShopService> services) {
		services.forEach(service -> service.setId(null));
		return repo.saveAll(services);
	}
}
