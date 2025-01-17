package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="User")
public class User implements Serializable{
	@Id
	@Column(length=30,name="Email")
	private String email;
	
	@Column(name="Name",length=30)
	private String name;
	
	@Column(name="Date_of_birth")
	private LocalDate dob;
	
	@Column(name="Date_of_creation")
	private final LocalDate doc = LocalDate.now(); 
	
	@Column(name="Mobile_No",length=15,unique=true)
	private String mob;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="user",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public User() {
		super();
	}

	public User(String email, String name, LocalDate dob, String mob) {
		super();
		this.email = email;
		this.name = name;
		this.dob = dob;
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public LocalDate getDoc() {
		return doc;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", dob=" + dob + ", doc=" + doc + ", mob=" + mob + "]";
	}

	
	
	
}
