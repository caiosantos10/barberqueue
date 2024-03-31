package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import jakarta.validation.constraints.NotNull;

@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "initial cannot be null")
	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDateTime initialTime;
	
	@JsonFormat(pattern = DATE_PATTERN)
	private LocalDateTime endTime;

	@NotNull(message = "customer cannot be null")
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@NotNull(message = "barber cannot be null")
	@ManyToOne
	@JoinColumn(name = "barber_id")
	private Barber barber;
	
	@NotNull(message = "isActive cannot be null")
	private boolean isActive;

	@NotNull(message = "services cannot be null")
	@ManyToMany
	@JoinTable(name = "Schedule_Service", joinColumns = @JoinColumn(name = "schedule_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<BarberShopService> services = new ArrayList<>();

	public Schedule() {

	}

	public Schedule(Integer id, LocalDateTime initialTime, LocalDateTime endTime, Customer customer, Barber barber, boolean isActive) {
		super();
		this.id = id;
		this.initialTime = initialTime;
		this.endTime = endTime;
		this.customer = customer;
		this.barber = barber;
		this.isActive = isActive;
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

	public void setInitialTime(LocalDateTime initialTime) {
		this.initialTime = initialTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
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
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsActive() {
		return isActive;
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
