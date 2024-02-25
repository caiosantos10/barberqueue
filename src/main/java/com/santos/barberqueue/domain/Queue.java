package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Queue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private ArrayList<String> customers = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getCustomers() {
		return customers;
	}

	public void setCustomers(String customer) {
		this.customers.add(customer);
	}

	@Override
	public String toString() {
		return "Queue [customers=" + customers.toString() + "]";
	}
	
}
