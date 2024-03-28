package com.santos.barberqueue.dto;

import java.io.Serializable;
import java.util.Objects;

import com.santos.barberqueue.domain.Avaliability;

public class BarberDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String cnpj;
	private String email;
	private String password;
	private Avaliability avaliability;

	public BarberDTO(Integer id, String name, String cnpj, String email, String password) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
		this.password = password;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	public Avaliability getAvaliability() {
		return avaliability;
	}

	public void setAvaliability(Avaliability avaliability) {
		this.avaliability = avaliability;
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
		BarberDTO other = (BarberDTO) obj;
		return Objects.equals(id, other.id);
	}
}
