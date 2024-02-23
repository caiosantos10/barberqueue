package com.santos.barberqueue.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.barberqueue.domain.Queue;

@RestController
@RequestMapping(value="/queue")
public class QueueResource {
	
	@GetMapping("")
	public Queue getQueue() {
		Queue myQueue = new Queue();
		myQueue.setCustomers("Fulano");
		myQueue.setCustomers("Sicrano");
		myQueue.setCustomers("Beltrano");
		
		return myQueue;
	}
}
