package com.santos.barberqueue.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.barberqueue.domain.Queue;
import com.santos.barberqueue.services.QueueService;

@RestController
@RequestMapping(value="/queue")
public class QueueResource {
	
	@Autowired
	private QueueService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> getQueue(@PathVariable Integer id) {
		Queue obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
