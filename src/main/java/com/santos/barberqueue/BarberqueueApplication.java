package com.santos.barberqueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santos.barberqueue.repositories.ScheduleRepository;

@SpringBootApplication
public class BarberqueueApplication implements CommandLineRunner {

	@Autowired
	private ScheduleRepository scheduleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BarberqueueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Schedule obj1 = new Schedule(null, "initialTime", "endTime", "Usuario 1");
//		Schedule obj2 = new Schedule(null, "initialTime", "endTime", "Usuario 2");
//		Schedule obj3 = new Schedule(null, "initialTime", "endTime", "Usuario 3");
//		Schedule obj4 = new Schedule(null, "initialTime", "endTime", "Usuario 4");
//
//		scheduleRepo.saveAll(Arrays.asList(obj1, obj2, obj3, obj4));

	}

}
