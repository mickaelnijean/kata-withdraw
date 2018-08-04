package com.kata.withdrawmicroservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.withdrawmicroservice.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer>{
	
}
