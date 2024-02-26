package com.santos.barberqueue.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.repositories.ScheduleRepository;
import com.santos.barberqueue.services.exceptions.ObjectNotFoundException;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository repo;
	
	public Schedule find(Integer id) {
		Optional<Schedule> obj  = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object is not found, Id: " + id + ", Type: " + Schedule.class.getName()));
	}
}
