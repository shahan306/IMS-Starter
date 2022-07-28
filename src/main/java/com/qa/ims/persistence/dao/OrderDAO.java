package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		long id = resultSet.getLong("id");
		String customerId = resultSet.getString("order_id");
		return new Order(id, customerId);
	}
	
	@Override
	public List<Order> readAll() {
	       try (Connection connection = DBUtils.getInstance().getConnection();
	                Statement statement = connection.createStatement();
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
	            List<Order> orders = new ArrayList<>();
	            while (resultSet.next()) {
	                orders.add(modelFromResultSet(resultSet));
	            }
	            return orders;
	        } catch (SQLException e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
	        return new ArrayList<>();
	}

	private Order readLatest() {
	   	try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
	 		return null;
	}
	
	@Override
	public Order create(Order orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders (customer_id) VALUES (?)");) {
			statement.setString(1, orders.getCustomer_id());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order read(Long id) {
    	try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
				.prepareStatement("UPDATE orders SET orders_name = ?, price = ? WHERE id = ?");) {
			statement.setLong(1, orders.getId());
			statement.setString(2, orders.getCustomer_id());
			statement.executeUpdate();
			return read(orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long orders) {
	  	try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE id = ?");) {
			statement.setLong(1, orders);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}