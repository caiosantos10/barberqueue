package com.santos.barberqueue.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.barberqueue.domain.Barber;
import com.santos.barberqueue.services.BarberService;

@RestController
@RequestMapping(value="/barber")
public class BarberResource {
	
	@Autowired
	private BarberService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable Integer id) {
		Barber obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}