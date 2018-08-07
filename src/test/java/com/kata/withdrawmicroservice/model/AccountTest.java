package com.kata.withdrawmicroservice.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.kata.withdrawmicroservice.model.Account;
import com.kata.withdrawmicroservice.model.Client;

public class AccountTest {
	
	Client client = new Client(new Long(0), "Pierre", "Jean");
	
	@Test
	public void withdrawMoneyTestAmountNull(){
		Account a = new Account(new Long(0), client, BigDecimal.TEN);
		try{
			a.withdrawMoney(null);
			Assert.fail("you can't withdraw null amount");
		}
		catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	public void withdrawMoneyTestNegativeAmount(){
		Account a = new Account(new Long(0), client, BigDecimal.TEN);
		try{
			a.withdrawMoney(BigDecimal.TEN.negate());
			Assert.fail("you can't withdraw negative amount");
		}
		catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	public void withdrawMoneyTestShouldReturnZero(){
		Account a = new Account(new Long(0), client, BigDecimal.TEN);
		try{
			Assert.assertEquals(BigDecimal.ZERO, a.withdrawMoney(BigDecimal.TEN));
		}
		catch(IllegalArgumentException e){
			Assert.fail("everything is ok");
		}
	}

}
