package com.santos.barberqueue.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.santos.barberqueue.domain.Customer;
import com.santos.barberqueue.dto.CustomerDTO;
import com.santos.barberqueue.repositories.CustomerRepository;
import com.santos.barberqueue.services.exceptions.DataIntegrityException;
import com.santos.barberqueue.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository repo;

	public Customer find(Integer id) {
		Optional<Customer> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object is not found, Id: " + id + ", Type: " + Customer.class.getName()));
	}

	public List<Customer> findAll() {
		List<Customer> obj = repo.findAll();
		return obj;
	}

	public Customer insert(Customer customer) {
		customer.setId(null);
		return repo.save(customer);
	}

	public void update(Customer newCustomer) {
		Customer customer = find(newCustomer.getId());
		try {
			updateData(customer, newCustomer);
		} catch (IllegalAccessException e) {
			throw new DataIntegrityException("Nâo foi possível atualizar os dados");
		}
		repo.save(newCustomer);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este Customer");
		}
	}

	public Customer toCustomerFromDTO(CustomerDTO dto) {
		return new Customer(dto.getId(), dto.getName(), dto.getNickname(), dto.getEmail(), dto.getPassword());
	}

	private void updateData(Customer customer, Customer newCustomer) throws IllegalAccessException {
		Field[] fields = Customer.class.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			Object sourceData = field.get(customer);
			Object targetData = field.get(newCustomer);

			if (sourceData != null && targetData == null && !field.getName().equals("serialVersionUID")) {
				field.set(newCustomer, sourceData);
			}
		}
	}
}
