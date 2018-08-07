package com.kata.withdrawmicroservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.withdrawmicroservice.model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long>{
	Optional<Account> findByClientId(Long clientId);
}
