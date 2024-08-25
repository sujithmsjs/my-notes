1. Explain about the TCL(Transaction Control Language)
2. DDL:

	- Data Defination Lanaguage: Used to define structure of the table.
	- In all database systems by default all DDL commands are automatically commited.
	
3. Avout Drop

	- It is used to remove database objects from the database.
	
	Syntax:
		drop <database_object> <object_name>
	Ex:
		drop table table_name
		drop view view_name
		
	- It is not possible to drop more than one table at a time.
	- When you first delete the object it will be sent to recycle bin.
	- You can flashback the object from the recycle bin.
	- You need to use the purge inorder to delete object peremenently.
	Ex:
		drop table table_name purge

Recycle bin:
	
	- It is a read only table which stores all the droped objects.
	- Read only tables: In oracle there read only tables also called as data dictionaries.
	- Ex:
		sql> desc recyclebin
		sql> select original_name from recyclebin
	- drop peremenently from recyclebin
		sql> purge recyclebin
		
Truncate:
	
	- This command is used to delete all the data perminently from a table.
	- Ex:
		sql> truncate table <table_name>
		
- How do you create a replica table?
	Syntax:
		- create table <new_table_name> as <DQL>
	sql> create table salary as select * from emp;

- How do you copy only columns but not the data?

- How to create a table from existing table?
	Syntax:
		- create table <new_table_name> as <DQL>
	sql> create table salary as select * from emp;

	Note: In all databases systems when we are coping table from the existing tables CONSRAINTS are never copied.
	Note: We can copy only columns name by making WHERE condition false.
	Syntax:
		create table <new_table> as <DQL with false where cause>\
	Ex:
		sql> create table empdup as select * from emp where 1=2


Q1. Write a query to print the Annual salary of the employees.
Q2. Print the total earning by adding salary + commision of each employee.
Q3. All employee who are not CLERKS
Q4. Employees who are getting more than 2000 salry and not CLERKS
Q5. Employees who are getting more than 2000 salry or CLERKS

Null:

	- Null is a undefined, unavailible, unknown value.
	- It is not same as zero.
	- Any arithmetic operation performed on null value, gives null.
	Ex:
		null + 50 = null
		
ifNull Method:
Two varients of ifNull method
- ifNull(comm, 0)
- ifNull(comm, 0, comm + 500)

Q6. Write a query to get the comission of the employees in emp table based on following conditions
	- It comission is null, then update commision to 500.
	- It commision is not null, then add 50 to existed one.


SRP:
A class should have one and only one responsibility.

Software compoenets should be open for extension, but closed for modification.



OCP:
Open for extention but slow for extension.

class Shape{
	public void getArea();
}

// Open for extension
Circle, Square, Rectangle extends Shape

// This method has closed for modification
public void findTotalArea(List<Shape>){
}

LSP:
Subtypes must be substitutale for their base types.


class Rect{
}

class Square extends{
}

findArea(Rect r){
}

Super class should be replacable by subclass.

ISP:
- The dependency of one class to another one should depend on the smallest possible interface.

-- Clients should not be forced to implement interfaces they don't use.
-- Instead of one fat interface many small interfaces are preferred based on groups of methods, each one serving one submodule.



Animal
- void feed();

Pet extends Animal
- void groom();

Dog extends Pet
- void feed();
- void groom();

Triger extends Animal
- void feed();

DIP
---




HirakiCP
--------

This is a very lightweight (at roughly 130Kb) and lightning-fast JDBC connection pooling framework developed by Brett Wooldridge around 2012.

spring.datasource.hikari.connectionTimeout=30000 

autoCommit
connectionTimeout
idleTimeout
maxLifetime
connectionTestQuery
connectionInitSql
validationTimeout
maximumPoolSize
poolName
allowPoolSuspension
readOnly
transactionIsolation
leakDetectionThreshold


Hikari provides support for monitoring its connection pool through JMX (Java Management Extensions). JMX is a Java technology that enables the management and monitoring of applications at runtime. By enabling JMX for Hikari, we can gain valuable insights into the health and performance of our connecti

spring.datasource.hikari.registerMbeans=true

With this configuration in place, Hikari exposes its management beans through JMX. These beans can be accessed using JMX tools and libraries to monitor and analyze the connection pool. There are several popular JMX clients available, such as JConsole, VisualVM, and Prometheus with JMX exporter.


A high-performance JDBC connection pool.



Secoundary Cache Configuraton
-----------------------------

What is dockers?



Redis as Chache
---------------

@EnableCache


@Cacheable(key = "#id", value = "Product")


Based on condition
------------------

@Cacheable(
	key = "#id",
	value = "Product",
	unless = #result.price > 1000)
	
@CacheEvict(key = "#id", value = "Product")


Redis as the Message Broker
---------------------------

