Coverage: 60% pottentaly could be 70/80 once i fix my errors in sql
# Project Title

This is my assignment from week 5, which highlights the abilities I have developed
while attending the QA Academy. It controls a MySQL database and is a Java-based
inventory management system. On database items in four separate tables, users
can carry out fundamental CRUD operations. Orders are accepted by the system,
which also generates a total price, based on the item IDs and quantities. which
later can be used or to be viewed or edited. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for 
development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Softwares used to make the app and project planing application.

•Java 17 JDK
•Maven
•Git for versioning
•git hub
•jira
•SQL
•Eclipse IDE


### Installing

use the qa template provided to you repo

To ensure that all dependencies are installed locally after being used, run mvn install.

Once mvn package clean has been executed, a jar file containing dependencies will be created in the target folder.

After that, you can either navigate to the project in cmd, git bash, or any other terminal and execute java -jar "file name" to start the application. Alternatively, you may right-click the fat jar in the project explorer and choose Show in > Terminal

customer is already done but you need to complete item first then you can make an order and have its functionality,


## Running the tests

Right-click on the project and select "coverage as" or "junit test" to launch the tests.

Tests There are three distinct test folders: one each for domains, the DAO, and controllers.

In the controller testing, Mockito is used. This makes it possible to do simulation tests.

``@Test public void testCreate() { final String I_NAME = "shahan"; final Double I_PRICE = 4.2; 
final Item created = new Item(I_NAME, I_PRICE);

	Mckito.when(utils.getString()).thenReturn(I_NAME);
	Mockito.when(utils.getDouble()).thenReturn(I_PRICE);
	Mockito.when(dao.create(created)).thenReturn(created);

	assertEquals(created, controller.create());

	Mockito.verify(utils, Mockito.times(1)).getString();
	Mockito.verify(utils, Mockito.times(1)).getDouble();
	Mockito.verify(dao, Mockito.times(1)).create(created);
}
The system under test is mocked or mimicked. As the create method in the DAO, which communicates 
with the database, is being tested, this would be an example of integration testing.

@Test
public void testCreate() {
	final Item created = new Item(2L, "Paper", 1.2);
	assertEquals(created, itemDAO.create(created));
}
``

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

You must connect this project to a database before you can launch it.
In this situation, I would advise establishing a connection to a MySQL database.
You must run the following commands when logged into MySQL in order to set up your database:

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

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **shahan shah** - *final work for project* - [shahan306](https://github.com/shahan306)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
