Coverage: 60% pottentaly could be 70/80 once i fix my errors in sql

Jira link:
[shahan306](https://shahan306.atlassian.net/jira/software/projects/IMSW5/boards/4/backlog)

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

### Unit Tests 

junit tests are designed to evaluate each method's functionality individually. For each method
in the Customer, Item, Order,  for instance, tests have been developed to ensure that the getters
and setters function properly, that objects and fields can be set to null, and many other things.
To make sure that the application functions properly, these tests must succeed. As an illustration,
consider the following test for the Item class' setters:

@Test
public void settersTest() {
	assertNotNull(item.getId());
	assertNotNull(item.getItemName());
	assertNotNull(item.getPrice());
	
	item.setId(null);
	assertNull(item.getId());
	item.setItemName(null);
	assertNull(item.getItemName());
	item.setPrice(null);
	assertNull(item.getPrice());	
}



### Integration Tests

For the application, Mockito has been used to create a number of integration tests. To avoid
having to call the method being tested directly, Mockito is used to stub the methods it calls.
This makes it possible to test more complicated methods and more successfully imitate application
functionality. Here is a test that examines the Customer controller's readAll() method.

@Test
public void readAllTest() {
	CustomerController customerController = new CustomerController(customerServices);
	List<Customer> customers = new ArrayList<>();
	customers.add(new Customer("shahan", "p"));
	customers.add(new Customer("mo", "m"));
	customers.add(new Customer("john", "J"));
	Mockito.when(customerServices.readAll()).thenReturn(customers);
	assertEquals(customers, customerController.readAll());
}

### And coding style tests

These tests are used to determine whether the industry standard for coverage is being reached.
If it is, you must achieve an average of 80%; if less, it is not a problem because it can be
fixed by refining the programmes. Codes may always be made simpler while programming to save
data and more. You can run coding style checks by adding the project to SonarQube. This server
will analyse the project and generate a variety of beneficial data, including code coverage.
Additionally, it will identify and recommend patches for bugs, security holes, and "code smells"
(maintenance problems) in the code.

Examples of code :

private Long id;
    private String itemName;
    private Float price;

    // constructor without id from source easy to generate
    public Item(String itemName,float price) {
        this.setItemName (itemName);
        this.setPrice (price);
    }

    // constructor with id from source
    public Item(Long id, String itemName, Float price) {
        this.id = id;
        this.setItemName (itemName);
        this.setPrice (price);
    }

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


* **shahan shah** - *final work for project* - [shahan306](https://github.com/shahan306)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
