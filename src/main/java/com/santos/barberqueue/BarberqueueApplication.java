package com.santos.barberqueue;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santos.barberqueue.domain.Queue;
import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.repositories.QueueRepository;
import com.santos.barberqueue.repositories.ScheduleRepository;

@SpringBootApplication
public class BarberqueueApplication implements CommandLineRunner {

	@Autowired
	private ScheduleRepository scheduleRepo;
	
	@Autowired
	private QueueRepository queueRepo;

	public static void main(String[] args) {
		SpringApplication.run(BarberqueueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Schedule obj1 = new Schedule(null, "initialTime", "endTime", "Usuario 1");
		Schedule obj2 = new Schedule(null, "initialTime", "endTime", "Usuario 2");
		Schedule obj3 = new Schedule(null, "initialTime", "endTime", "Usuario 3");
		Schedule obj4 = new Schedule(null, "initialTime", "endTime", "Usuario 4");

		Queue queue = new Queue(null);
		queue.getSchedules().addAll(Arrays.asList(obj1, obj2, obj3, obj4));
		
		obj1.setQueue(queue);
		obj2.setQueue(queue);
		obj3.setQueue(queue);
		obj4.setQueue(queue);

		scheduleRepo.saveAll(Arrays.asList(obj1, obj2, obj3, obj4));
		queueRepo.save(queue);

	}

}
