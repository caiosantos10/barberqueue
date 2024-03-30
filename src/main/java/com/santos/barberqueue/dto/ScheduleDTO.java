package com.santos.barberqueue.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private LocalDateTime initialTime;
	private LocalDateTime endTime;
	private Integer customerId;
	private Integer barberId;
	private boolean status;
	private List<Integer> servicesIds = new ArrayList<>();
	
	public ScheduleDTO() {
		
	}

	public ScheduleDTO(Integer id, LocalDateTime initialTime, LocalDateTime endTime, Integer customerId, Integer barberId, boolean status) {
		this.id = id;
		this.initialTime = initialTime;
		this.endTime = endTime;
		this.customerId = customerId;
		this.barberId = barberId;
		this.status = status;
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getBarberId() {
		return barberId;
	}

	public void setBarberId(Integer barberId) {
		this.barberId = barberId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Integer> getServicesIds() {
		return servicesIds;
	}

	public void setServices(Integer servicesId) {
		this.servicesIds.add(servicesId);
	}
}
