package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Avaliability implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private List<LocalDateTime> bookedTimes = new ArrayList<>();
	
	@NotNull(message = "services cannot be null")
	@ManyToMany
	@JoinTable(name = "Avaliability_Services", joinColumns = @JoinColumn(name = "avaliability_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<BarberShopService> servicesOffered = new ArrayList<>();
	
	public List<BarberShopService> getServicesOffered() {
		return servicesOffered;
	}

	public void setServicesOffered(List<BarberShopService> servicesOffered) {
		this.servicesOffered = servicesOffered;
	}

	public List<LocalDateTime> getBookedTimes() {
		return bookedTimes;
	}

	public void setBookedTimes(List<LocalDateTime> bookedTimes) {
		this.bookedTimes = bookedTimes;
	}
	
	public void addBookedTime(LocalDateTime bookedTime) {
		this.bookedTimes.add(bookedTime);
	}
}
