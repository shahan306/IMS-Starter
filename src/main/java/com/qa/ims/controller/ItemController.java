package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

  
  

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO ItemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	
		
	}

	@Override
	public Item create() {
		// TODO Auto-generated method stub
		LOGGER.info("Enter the item name");
		String itemName = utils.getString();
		LOGGER.info("Enter a price");
		Float price = utils.getFloat();
		Item item = itemDAO.create(new Item(itemName, price));
		LOGGER.info("Customer created");
		return item;
	}

	@Override
	public Item update() {
		// TODO Auto-generated method stub
		LOGGER.info("Please input the id number of item which you would like to edit");
		Long id = utils.getLong();
		LOGGER.info("Enter the item number");
		String itemName = utils.getString();
		LOGGER.info("Enter a price");
		Float price = utils.getFloat();
		Item item = itemDAO.update(new Item(id, itemName, price));
		LOGGER.info("Customer has been Updated");
		return item;
		
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
		
	}
	

}