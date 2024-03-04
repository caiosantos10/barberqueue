package com.santos.barberqueue.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.services.ScheduleService;

@RestController
@RequestMapping(value="/schedules")
public class ScheduleResource {
	
	@Autowired
	private ScheduleService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable Integer id) {
		Schedule obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllSchedules() {
		List<Schedule> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
}
