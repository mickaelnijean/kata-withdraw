package com.kata.withdrawmicroservice.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Client {
	
	private Long id;
	private String firstName;
	private String lastName;
	
	public Client(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	

}
