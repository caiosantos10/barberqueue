package com.santos.barberqueue.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Customer;
import com.santos.barberqueue.repositories.CustomerRepository;
import com.santos.barberqueue.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;
	
	public Customer find(Integer id) {
		Optional<Customer> obj  = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object is not found, Id: " + id + ", Type: " + Customer.class.getName()));
	}
	
	public Customer insert(Customer customer) {
		customer.setId(null);
		return repo.save(customer);
	}
	
	public Customer update(Customer customer) {
		find(customer.getId());
		return repo.save(customer);
	}
}
