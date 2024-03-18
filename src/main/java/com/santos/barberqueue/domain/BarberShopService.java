package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.time.Duration;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Service")
public class BarberShopService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "name cannot be null")
	@Size(min = 3, max = 50, message = "name has to be min 3 and max 50")
	private String name;
	
	@NotNull(message = "price cannot be null")
	private Double price;
	
	@NotNull(message = "duration cannot be null")
	private Duration duration;

	public BarberShopService() {

	}

	public BarberShopService(Integer id, String name, Double price, Integer duration) {
		this.id = id;
		this.name = name;
		this.price = price;
		setDuration(duration);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = Duration.ofMinutes(duration);
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
		BarberShopService other = (BarberShopService) obj;
		return Objects.equals(id, other.id);
	}

}
