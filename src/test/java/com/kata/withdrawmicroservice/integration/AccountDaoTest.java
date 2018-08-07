package com.kata.withdrawmicroservice.integration;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kata.withdrawmicroservice.dao.AccountDao;
import com.kata.withdrawmicroservice.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDaoTest {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void getPierrJeanByClientId(){
		Optional<Account> accountO = accountDao.findByClientId(new Long(0));
		Assert.assertTrue(accountO.isPresent());
		Account account = accountO.get();
		Assert.assertEquals("Jean", account.getClientId());
	}
	
}
