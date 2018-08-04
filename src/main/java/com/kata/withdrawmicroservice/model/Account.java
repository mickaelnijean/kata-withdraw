package com.kata.withdrawmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	private int id;
	private String prenom;
	private String nom;
	private float amount;

	public Account() {
	}

	public Account(int id, String prenom, String nom, float amount) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.amount = amount;
	}
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Hello " + prenom + " " + nom + " you have " + amount
				+ "€ on your account!!";
	}
}
