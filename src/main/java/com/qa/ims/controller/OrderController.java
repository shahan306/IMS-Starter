package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

    public static final Logger Logger = LogManager.getLogger();

    private OrderDAO orderDAO;
    private Utils utils;

    public OrderController(OrderDAO orderDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }

    @Override
    public List<Order> readAll() {
        List<Order> orders= orderDAO.readAll();
        for (Order order : orders) {
            Logger.info(order);
        }
        return null;
    }

    @Override
    public Order create() {
        Logger.info("Enter a an customer ID :)");
        Long customer_Id = utils.getLong();
        Order order = orderDAO.create(new Order(customer_Id));
        Logger.info(" created");
        return order;
    }

    public Order update() {
        Logger.info("Enter the id of the orders you would like to update");
        Long id = utils.getLong();
        Logger.info("Please enter a customer id");
        long newcustomer_id = utils.getLong();
        Order order = orderDAO.read(id);
        order.setCustomer_id(newcustomer_id);
        order = orderDAO.update(order);
        Logger.info("Customer Updated");
        return order;
    }
    @Override
    public int delete() {
        Logger.info("Enter the id of the order you would like to delete");
        Long id = utils.getLong();
        Logger.info("ORDER DELETED! :)");
       
        return orderDAO.delete(id);
    }

}