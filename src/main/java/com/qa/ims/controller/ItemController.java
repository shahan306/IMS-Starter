package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

  
  

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO ItemDAO;
	private Utils utils;

	public ItemController(ItemDAO ItemDAO, Utils utils) {
		super();
		this.ItemDAO = ItemDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		List<Item> items = ItemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	
		
	}

	@Override
	public Item create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}