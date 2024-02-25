package com.santos.barberqueue.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Queue;
import com.santos.barberqueue.repositories.QueueRepository;

@Service
public class QueueService {
	@Autowired
	private QueueRepository repo;
	
	public Queue find(Integer id) {
		Optional<Queue> queue  = repo.findById(id);
		return queue.orElse(null);
	}
}
