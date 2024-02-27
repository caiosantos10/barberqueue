package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String initialTime;
	private String endTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "barber_id")
	private Barber barber;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Service> services = new ArrayList<>();

	public Schedule() {

	}

	public Schedule(Integer id, String initialTime, String endTime, Customer customer) {
		super();
		this.id = id;
		this.initialTime = initialTime;
		this.endTime = endTime;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(String initialTime) {
		this.initialTime = initialTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, endTime, id, initialTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(endTime, other.endTime)
				&& Objects.equals(id, other.id) && Objects.equals(initialTime, other.initialTime);
	}

}
