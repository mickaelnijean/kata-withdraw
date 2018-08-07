package com.kata.withdrawmicroservice.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account {
	private Long id;
	@OneToOne(fetch = FetchType.LAZY,
            optional=false)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	private BigDecimal amount;

	public Account() {
	}

	public Account(Long id, Client client, BigDecimal amount) {
		super();
		this.id = id;
		this.client = client;
		this.amount = amount;
	}
	@Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public BigDecimal withdrawMoney(BigDecimal amount){
		if(amount==null){
			throw new IllegalArgumentException("you can't withdraw null amount");
		}
		if(amount.compareTo(BigDecimal.ZERO)<0){
			throw new IllegalArgumentException("you can't withdraw negative amount");
		}
		return this.amount.subtract(amount);
	}
	
	public Long getClientId(){
		return this.client.getId();
	}
	
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return " You have " + amount
				+ "€ on your account!!";
	}
}
