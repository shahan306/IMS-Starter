drop database if exists InventorySystemManagerProject;
CREATE DATABASE IF NOT EXISTS InventorySystemManagerProject;
USE InventorySystemManagerProject;

CREATE TABLE customers (
	id INT AUTO_INCREMENT,
    first_name varchar(50),
    surname varchar(50),
    PRIMARY KEY (id)
    );
    
CREATE TABLE items (
	id INT AUTO_INCREMENT,
    item_name varchar(50),
    price decimal(8,0),
    PRIMARY KEY (id)
    );
    
    
CREATE TABLE orders (
	id int AUTO_INCREMENT,
    customer_id INT,
    total_price decimal(8,0),
    quantity INT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) 
		REFERENCES customers(id)
    );
    
CREATE TABLE order_items (
    id INT AUTO_INCREMENT,
    item_id INT,
    quantity INT,
    order_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id)
        REFERENCES orders(id),
    FOREIGN KEY (item_id)
        REFERENCES items(id)
);
