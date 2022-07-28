drop database if exists InventorySystemManager;
CREATE DATABASE IF NOT EXISTS InventorySystemManager;
USE InventorySystemManager;

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
   order_id INT AUTO_INCREMENT,
   id INT(11),
   item_id INT(11),
   qty INT (10),
   total_cost DOUBLE(12, 2),
   PRIMARY KEY (order_id),
   FOREIGN KEY (id) REFERENCES customers(id),
   FOREIGN KEY (item_id) REFERENCES items(item_id)
);