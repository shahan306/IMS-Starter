package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO orderDAO;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long I_ID = 1L, C_ID = 1L;
		final Long QTY = (long) 3;
		final Order created = new Order(I_ID, C_ID, QTY);

		Mockito.when(utils.getLong()).thenReturn(I_ID, C_ID);
		Mockito.when(utils.getLong()).thenReturn(QTY);
		Mockito.when(orderDAO.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderDAO, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L, (long) 12));

		Mockito.when(orderDAO.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(orderDAO, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Order updated = new Order(1L, 1L, 1L);

		Mockito.when(this.utils.getLong()).thenReturn(updated.getOrderId(), updated.getCustomerId(), updated.getItemId());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getQty());
		Mockito.when(this.orderDAO.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(3)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.orderDAO, Mockito.times(1)).update(updated);
	}
	
	@Test
	public void testDelete() {
		final long orderId = 1L;

		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(orderDAO.delete(orderId)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderDAO, Mockito.times(1)).delete(orderId);
	}

}