package com.santos.barberqueue.domain;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	private ArrayList<String> customers = new ArrayList<>();

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
