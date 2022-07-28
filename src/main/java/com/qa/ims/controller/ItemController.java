package com.qa.ims.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	@Override
	public List<Item> readAll() {
		List<Item> items= itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Enter An Item Name");
		String itemName = utils.getString();
		LOGGER.info("Enter A Price For Item");
		float price = utils.getFloat();
		Item item = itemDAO.create(new Item(itemName, price));
		LOGGER.info("Item Has Been Created");
		return item;
	}

	@Override
	public Item update() {
		LOGGER.info("Enter The ID Of The Item You Would Like To Update");
		Long id = utils.getLong();
		LOGGER.info("Please Enter A Item Name");
		String itemName = utils.getString();
		LOGGER.info("Please Enter A Price");
		float price = utils.getFloat();
		Item item = itemDAO.update(new Item(id, itemName, price));
		LOGGER.info("Customer Updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Enter The ID of The Item You Would Like To Delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}
}
