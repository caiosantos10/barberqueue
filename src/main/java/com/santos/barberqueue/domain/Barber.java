package com.santos.barberqueue.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Barber implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "name cannot be null")
	@Size(min = 3, max = 30, message = "name has to be min 3 and max 30")
	private String name;
	
	@NotNull(message="cnpj cannot be null")
	private String cnpj;
	
	@Email(message = "email is invalid")
	@Size(min = 3, max = 30, message = "email has to be min 3 and max 30")
	@NotNull(message = "email cannot be null")
	private String email;

	@NotNull(message = "password cannot be null")
	@Size(min = 3, max = 30, message = "name has to be min 3 and max 30")
	private String password;
	
	@OneToOne
	@JoinColumn(name="avaliability_id")
	private Avaliability avaliability;

	public Barber() {

	}

	public Barber(Integer id, String name, String cnpj, String email, String password) {
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

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setName(String name) {
		this.name = name;
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
		Barber other = (Barber) obj;
		return Objects.equals(id, other.id);
	}
}
