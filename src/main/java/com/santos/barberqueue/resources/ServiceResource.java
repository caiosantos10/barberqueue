package com.santos.barberqueue.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.barberqueue.domain.BarberShopService;
import com.santos.barberqueue.services.BarberShopServiceService;

@RestController
@RequestMapping(value="/service")
public class ServiceResource {
	
	@Autowired
	private BarberShopServiceService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable Integer id) {
		BarberShopService obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}