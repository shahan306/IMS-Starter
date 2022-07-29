package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		
		LOGGER.info("Please Enter The customeromer ID!:");
		Long custId = utils.getLong();
		LOGGER.info("Please Enter The Item ID!:");
		Long itemId = utils.getLong();
		LOGGER.info("Please Enter The Quantity?:");
		Long qty = utils.getLong();
		Order order = orderDAO.create(new Order(custId, itemId, qty));
		LOGGER.info("Order Has Been Created");
		return order;
	}

	@Override
	public Order update() {
		
		LOGGER.info("Please Enter The ID oF The Order You Would Like To Update: :) ");
		Long orderId = utils.getLong();
		LOGGER.info("Please Enter The New Item ID: ");
		Long itemId = utils.getLong();
		LOGGER.info("Enter A quantity: ");
		Long qty = utils.getLong();
		LOGGER.info("Please Enter The customeromer ID");
		Long custId = utils.getLong();
		Order order = orderDAO.update(new Order(orderId, custId, itemId, qty));
		return order;
	}

	@Override
	
	public int delete() {
		
		LOGGER.info("Please Enter The ID Of The Order You Want To Delete");
		Long orderId = utils.getLong();
		LOGGER.info("Order Has Been Deleted");
		return orderDAO.delete(orderId);
	}

}


