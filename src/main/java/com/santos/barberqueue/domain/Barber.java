package com.santos.barberqueue.domain;

import java.util.Objects;

import jakarta.persistence.Entity;

@Entity
public class Barber extends Person {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	public Barber(Integer id, String name, String nickname, String email, String password) {
		super(id, name, nickname);
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, password);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barber other = (Barber) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

}
