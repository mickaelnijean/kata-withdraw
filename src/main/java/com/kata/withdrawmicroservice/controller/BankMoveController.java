package com.kata.withdrawmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kata.withdrawmicroservice.service.BankMoveService;

@RestController
public class BankMoveController {

	@Autowired
	BankMoveService service;

	@GetMapping(value = "/withdraw/{id}/{amount}")
	public String withdraw(@PathVariable int id, @PathVariable int amount) {
		float updateAmountInAccount = service.updateAmountInAccount(id, amount);
		if (updateAmountInAccount != -1) {
			return "il ne reste plus que " + (updateAmountInAccount);
		} else {
			return "Opération impossible";
		}
	}

}
