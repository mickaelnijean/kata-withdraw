package com.kata.withdrawmicroservice;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.kata.withdrawmicroservice.dao.AccountDao;
import com.kata.withdrawmicroservice.model.Account;
import com.kata.withdrawmicroservice.service.BankMoveService;
import com.kata.withdrawmicroservice.service.BankMoveServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankMoveServiceTest {
	
	@TestConfiguration
    static class BankMoveServiceImplTestContextConfiguration {
  
        @Bean
        public BankMoveService bankMoveService() {
            return new BankMoveServiceImpl();
        }
    }
	
	@Autowired
	BankMoveService bankMoveService;
	
	@MockBean
	AccountDao dao;
	
	@Before
	public void setUp() {
		Optional<Account> pierre = Optional.of(new Account(12345,"Pierre","Jean",0.00f));
		Optional<Account> paul = Optional.of(new Account(12345,"Paul","Jean",-100.00f));
		Optional<Account> jacques = Optional.of(new Account(12345,"Jacques","Jean",100.00f));
	 
		Mockito.when(dao.findById(1))
	      .thenReturn(pierre);
		Mockito.when(dao.findById(2))
	      .thenReturn(paul);
		Mockito.when(dao.findById(3))
	      .thenReturn(jacques);
	}
	
	@Test
	public void updateAmountInAccountTestAccountNull(){
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(4, 10))
		.isEqualTo(-1);
	}
	
	@Test
	public void updateAmountInAccountTestAmountNullInAccount(){
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(1, 0))
		.isEqualTo(-1);
	}
	
	@Test
	public void updateAmountInAccountTestAmountNegativeInAccount(){
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(2, 0))
		.isEqualTo(-1);
	}
	
	@Test
	public void updateAmountInAccountTestNotEnoughtMoney(){
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(3, 150))
		.isEqualTo(-1);
	}
	
	@Test
	public void updateAmountInAccountTestamountIsNegative(){
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(3, -10))
		.isEqualTo(-1);
	}
	
	@Test
	public void updateAmountInAccountTestAmountIsTen(){
		float initValue = dao.findById(3).get().getAmount();
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(3, 10))
		.isEqualTo(initValue-10);
	}
	
	@Test
	public void updateAmountInAccountTestAmountIsTenAndTenAgain(){
		float initValue = dao.findById(3).get().getAmount();
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(3, 10))
		.isEqualTo(initValue-10);
		Assertions
		.assertThat(bankMoveService.updateAmountInAccount(3, 10))
		.isEqualTo(initValue-20);
	}

	
}
