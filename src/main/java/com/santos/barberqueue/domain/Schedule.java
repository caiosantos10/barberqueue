package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDateTime initialTime;
	
	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDateTime endTime;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "barber_id")
	private Barber barber;

	@ManyToMany
	@JoinTable(name = "Schedule_Service", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<BarberShopService> services = new ArrayList<>();

	public Schedule() {

	}

	public Schedule(Integer id, String initialTime, String endTime, Customer customer, Barber barber) {
		super();
		this.id = id;
		setInitialTime(initialTime);
		setEndTime(endTime);
		this.customer = customer;
		this.barber = barber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getInitialTime() {
		return initialTime;
	}

	public void setInitialTime(String initialTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		this.initialTime = LocalDateTime.parse(initialTime, formatter);
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
		this.endTime = LocalDateTime.parse(endTime, formatter);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Barber getBarber() {
		return barber;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public List<BarberShopService> getServices() {
		return services;
	}

	public void setServices(List<BarberShopService> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

}
