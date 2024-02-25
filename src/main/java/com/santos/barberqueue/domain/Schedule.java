package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String initialTime;
	private String endTime;
	private String customer;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn()
	private Queue queue;

	public Schedule() {

	}

	public Schedule(Integer id, String initialTime, String endTime, String customer) {
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
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
