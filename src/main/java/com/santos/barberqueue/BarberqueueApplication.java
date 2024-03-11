package com.santos.barberqueue;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santos.barberqueue.domain.Barber;
import com.santos.barberqueue.domain.BarberShopService;
import com.santos.barberqueue.domain.Customer;
import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.repositories.BarberRepository;
import com.santos.barberqueue.repositories.BarberShopServiceRepository;
import com.santos.barberqueue.repositories.CustomerRepository;
import com.santos.barberqueue.repositories.ScheduleRepository;

@SpringBootApplication
public class BarberqueueApplication implements CommandLineRunner {

	@Autowired
	private ScheduleRepository scheduleRepo;
	@Autowired
	private BarberRepository barberRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private BarberShopServiceRepository barberShopServiceRepo;

	public static void main(String[] args) {
		SpringApplication.run(BarberqueueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BarberShopService service1 = new BarberShopService(null, "Cabelo", 50.00);
		BarberShopService service2 = new BarberShopService(null, "Barba", 15.00);
		
		Customer customer1 = new Customer(null, "Caio Santos", "Caio");
		Customer customer2 = new Customer(null, "Robson Santos", "Cacá");
		Customer customer3 = new Customer(null, "Iuri Santos", "Iuri");
		
		Barber barber = new Barber(null, "Barbeiro Teste", "teste@teste.com", "123456");
		
		barber.setServicesOffered(Arrays.asList(service1, service2));;
		
		Schedule sched1 = new Schedule(null, "2020-12-12T11:30:00", "2020-12-12T11:30:00", customer1, barber);
		Schedule sched2 = new Schedule(null, "2020-12-12T11:30:00", "2020-12-12T11:30:00", customer2, barber);
		Schedule sched3 = new Schedule(null, "2020-12-12T11:30:00", "2020-12-12T11:30:00", customer3, barber);
		
		sched1.setServices(Arrays.asList(service1, service2));
		sched2.setServices(Arrays.asList(service1));
		sched3.setServices(Arrays.asList(service1));

		
		barberShopServiceRepo.saveAll(Arrays.asList(service1, service2));
		barberRepo.saveAll(Arrays.asList(barber));
		customerRepo.saveAll(Arrays.asList(customer1, customer2, customer3));
		scheduleRepo.saveAll(Arrays.asList(sched1, sched2, sched3));

	}

}
