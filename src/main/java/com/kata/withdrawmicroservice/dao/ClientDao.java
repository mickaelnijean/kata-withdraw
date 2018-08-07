package com.kata.withdrawmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.withdrawmicroservice.model.Client;

@Repository
public interface ClientDao extends JpaRepository<Client, Long>{
	List<Client> findByFirstName(String firstName);
}
