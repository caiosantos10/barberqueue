package com.santos.barberqueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santos.barberqueue.domain.Avaliability;
import com.santos.barberqueue.domain.Barber;
import com.santos.barberqueue.domain.BarberShopService;
import com.santos.barberqueue.domain.Customer;
import com.santos.barberqueue.domain.Schedule;
import com.santos.barberqueue.repositories.AvaliabilityRepository;
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
	@Autowired
	private AvaliabilityRepository avaliabilityRepo;
	
	private final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	public static void main(String[] args) {
		SpringApplication.run(BarberqueueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BarberShopService service1 = new BarberShopService(null, "Cabelo", 50.00, 60);
		BarberShopService service2 = new BarberShopService(null, "Barba", 15.00, 30);
		
		Customer customer1 = new Customer(null, "Caio Santos", "Caio", "caio@teste.com", "1234");
		Customer customer2 = new Customer(null, "Robson Santos", "Cacá", "caca@teste.com", "1234");
		Customer customer3 = new Customer(null, "Iuri Santos", "Iuri", "iuri@teste.com", "1234");
		
		Barber barber = new Barber(null, "Barbeiro Teste", "00000000000000", "teste@teste.com", "123456");
		
		Avaliability avaliability = new Avaliability();
		avaliability.setServicesOffered(Arrays.asList(service1, service2));
		
		barber.setAvaliability(avaliability);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		LocalDateTime initialDate = LocalDateTime.parse("2020-12-12T11:30:00", formatter);
		LocalDateTime endDate = LocalDateTime.parse("2020-12-12T12:30:00", formatter);
		
		Schedule sched1 = new Schedule(null, initialDate, endDate, customer1, barber, true);
		Schedule sched2 = new Schedule(null, initialDate, endDate, customer2, barber, true);
		Schedule sched3 = new Schedule(null, initialDate, endDate, customer3, barber, true);
		
		sched1.setServices(Arrays.asList(service1, service2));
		sched2.setServices(Arrays.asList(service1));
		sched3.setServices(Arrays.asList(service1));

		
		barberShopServiceRepo.saveAll(Arrays.asList(service1, service2));
		avaliabilityRepo.saveAll(Arrays.asList(avaliability));
		barberRepo.saveAll(Arrays.asList(barber));
		customerRepo.saveAll(Arrays.asList(customer1, customer2, customer3));
		scheduleRepo.saveAll(Arrays.asList(sched1, sched2, sched3));

	}

}
