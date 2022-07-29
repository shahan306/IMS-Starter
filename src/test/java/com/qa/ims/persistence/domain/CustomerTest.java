package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	@Test
	public void toStringTest() {
		
		Customer customer = new Customer(1L, "SHAHAN", "SHAH");
		
		String expected = "id:1 first name:shahan surname:shah";
		assertEquals(expected, customer.toString());
	}

	@Test
	public void firstConstructorTest() {
		
		Customer customer = new Customer("chris", "wasteage");
		
		assertEquals("chris", customer.getFirstName());
		assertEquals("wasteage", customer.getSurname());

	}

	@Test
	public void secondConstructorTest() {
		
		Customer customer = new Customer(1L, "jonny", "smally");
		
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("jonny", customer.getFirstName());
		assertEquals("smally", customer.getSurname());

	}

}