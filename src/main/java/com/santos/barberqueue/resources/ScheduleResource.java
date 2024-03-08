package com.santos.barberqueue.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.services.ScheduleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/schedules")
public class ScheduleResource {
	
	@Autowired
	private ScheduleService service;
	
	@GetMapping()
	public ResponseEntity<?> findAll() {
		List<Schedule> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Schedule obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Schedule schedule) {
		schedule = service.insert(schedule);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(schedule.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Schedule schedule, @PathVariable Integer id) {
		schedule.setId(id);
		schedule = service.update(schedule);
		return ResponseEntity.noContent().build();
	}
}
