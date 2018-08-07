package com.kata.withdrawmicroservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.withdrawmicroservice.dao.AccountDao;
import com.kata.withdrawmicroservice.model.Account;

@Service("bankMoveService")
public class BankMoveServiceImpl implements BankMoveService{
	
	@Autowired
	AccountDao dao;

	public float updateAmountInAccount(int id, int amount) {
		Optional<Account> accountO = dao.findById(id);
		dao.findByPrenom("Pierre");
		if(!accountO.isPresent()){
			return -1;
		}
		Account account = accountO.get();
		if( (account ==null)
				|| (account.getAmount()<=0) 
				|| (amount>account.getAmount()) 
				|| (amount <0) ){
			return -1;
		}
		account.setAmount(account.getAmount()-amount);
		dao.save(account);
		return account.getAmount();
	}

}
