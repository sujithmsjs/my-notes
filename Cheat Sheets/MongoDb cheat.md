NoSQL

https://www.mongodb.com/scale/nosql-vs-relational-databases#:~:text=Relational%20databases%20are%20table%2Dbased,today%20is%20much%20more%20complex.

the traditional SQL-based relational database was less equipped to handle rapidly expanding data volumes and the growing complexities of data structures

 In the last decade, the non-relational, NoSQL databases became more popular for offering a more flexible, scalable, cost-efficient, alternative to the traditional SQL-based relational databases.
 
 
  In the last decade, the non-relational, NoSQL databases became more popular for offering a more flexible, scalable, cost-efficient, alternative to the traditional SQL-based relational databases.
  
  Relational databases are table-based. NoSQL databases can be document based, graph databases, key-value pairs, or wide-column stores.
  
  NoSQL databases are designed to handle the more complex, unstructured data, (such as texts, social media posts, photos, videos, email) which increasingly make up much of the data that exists today.
  
MongoDB:
HuMONGOus: extremely large : huge a humongous building humongous amounts of money.

MongoDB is the most popular and treading database.

Vendor: MongoDB corp
https://www.mongodb.com/
Atlas→Multi-cloud database platform

Where we can use?
* Everywhere!
1. Desktop Apps
2. Mobile Apps
3. Web Applications


FULL STATCK DEVELOPER:
STACK --->: To develop WEB APPS
The technologies which can be used to develop web apps r called a stack.

STACKS:
1. MEAN STACK DEVELOPER
------------------------
M - MongoDB
E - Express
A - Angular
N - Node JS

2. MERN STACK  DEVELOPER
------------------------
M - MongoDB
E - Express
R - React JS
N - Node JS

1. Front End
(Angular, React JS)
2. Back End
(Express JS)
3. Server side runtime environment
(Node JS)
4. Database
(MongoDB)

Note: 2 & 3 Back End

1. NOTE
BY USING MEAN AND MERN STACKS WE CAN BUILD JAVASCRIPT BASED WEB APPLICATIONS.

2. NOTE:
MONGODB IS ALSO BASED ON JAVASCRIPT.

MangoDB internally uses Mozilla's Spider Monkey JavaScript Engine.

3. What is the type of MongoDB database?
NoSQL Database/Document Database

Relational Database vs Document Database
---------------------------------
There r 2 most common types of DBs.
1. RDB RELATIONAL_DS/SQL
- Tables has fixed schema(Structure)
- Tables has Relationships
- has Joins
Ex: Oracle, MySQL, DB2 etc

2. DDB DOCUMENT_DB/NOSQL
Data will be stored in different documents. Each document is independent of others.

Collection as a Table
Each Document is like a ROW.
DATA stroed inside Document

Database{
	Collection-1 {
		Docs{}
		Docs{}
		Docs{}
		...
	}
	Collection-2{
		Docs{ }
		Docs{}
		Docs{}
		...
	}
	...
	Collection-N{
		Docs{}
		Docs{}
		Docs{}
		...
	}
}
Data will be stored in documents.
Eash Document is independent of others.
Not have fixed schema.
Eg: MongoDB


MONGO-DB STRUCURE:
--------------------
MongoDB Physical DB contains several logical DBs.
It logical DB can have multiple Databases.
Each DB contains multiple Collections(Table in RDB).
Each Collection contains multiple Documents(Rows in RDB table).

Ex:
Database: Shopping cart database
	Collections:
		Customer,
		Products,
		Orders
		
How data represented in MongoDB?		
Customer Collection: Contains several documents
document 1:
	{
		'Name' : 'Sujith',
		'Age' : 23,
		'Salary':10000
	}
document 2:
	{
		'Name' : 'Maximus',
	}
document 3:
	{
		"name": "Bunny",
		"Age": 30
		"Address":
			{
				"City": "Hyderabad"
			}
		"hobbies":
			[
				{"name" : "Cricket"},
				{"name" : "Swimming"},
				{"name" : "Football"}
			]
	}

Data Represent in MongoDB
In JSON (BSON) Format.
BSON: Binary JSON

------------
- Fetching is Speed
- Performance
- JSON Data representation

Key Characteristics of MongoDB Database?
1. Complete data is available in single place. Hence, retrieval of data is extreamly fast and not need Join operations.
2. Documents are independent of each other and no scheme. Hence, we can store unstructured data like videos, audio file etc.
3. CRUD operations on documents are strinless.
4. Retrieval data is in the form of JSON which can be understandable by any programming language without any conversation(Interoperability).
5. Huge amout of data can be stored. Scalablity is more.
6. Installation and setup is very easy.

Note: Performance and flexible are biggest assets of MongoDB.

MongoDB
Hu-Mongo-us
-----------
We can MongoDB everywhere.

MongoDB internally uses JavaScript based engine.

Physical level: BSON
Logically stores: JSON

Document Type DB/NoSQL DB
No tables 
No fixed schema
No joins/join queries
No Relations
Data stored in Documents
Docs have
ve no schema, performance is more.

Eg: MongoDB, Cassandra, HBase etc.

---
MongoDB
Physical DB contains severl Logical DBs.
Logical DB contains several Collections.
Each Collections contains several Documents.
Data saved in the Documents in BSON format.

NoSQL -> Not only SQL.
---

INSTALATION MongoDB
Once we install MongoDB, we will get MongoDB Shell and MongoDB Server.

MongoDB Server stores data in MongoDB and is responsible to store data.

Server can be either Local or Remote/Cloud.
Mongo Atlas: Cloud based MongoDB.

MongoDB Shell
To manage MongoDB Server, we require MongoDB Shell.
It is like Client application. 
To perform CRUD Operations.

---
mongod: to start/launch server.
mongo: to start/launch shell.
Multiple GUIs Support is also there for MongoBS shell:
- Compass
- Robo T3
---
MongoDB Drivers
From Applications(Java,Phytho,C# etc) if we want to communicate with DB, some special S/W.

Docs TAP > Drivers(Language APS)

Default Port no: 27017

Enterprise versions and Community versions.
-----------------------

MongoDB Installation
-----------------

Website > Community Server
Verson

https://www.mongodb.com/

MongoDB Community Server
Complete version -> Instal MongoDB as a service. > Run service as netword service user.

MongoDB\Server\4.4\bin
mongod -version(Server)
mongo -version(Shell)

path: MongoDB\Server\4.4\bin

Launch:
mongod(To launch Server)
NonExistentPath: Data directory D:\\data\\db\\ not found. Create the missing directory or specify another path using(1) the --dbpath command line option, or (2) by adding the 'storage.dbPath' option in the configuration file.

mongod --dbpath "c:\data\db"
mongo(To launch Shell)

> db.version()
> db.help()
> db.stats() // Statistics
db is predefined object
> show dbs
admin,config,local
> use admin
> show collections
system.version
> use local
> show collections
startup_log

---

What is MongoDB




"MongoDB is a scalable, open source, high performance, document-oriented database." - 10gen




db.createCollection("emp", 
	{
	empno : 7369,
	ename : "",
	job : "",
	mgr : 7902,
	hiredate : new Date(),
	sal : 0,
	comm : 0,
	deptno : 20
	}
)

db.emp.insert(
{
        "empno" : 7369,
        "ename" : "SMITH",
        "job" : "CLERK",
        "mgr" : 7902,
        "hiredate" : new Date(1980-12-17),
        "sal" : 800.00,
        "comm" : "NULL",
        "deptno" : 20
}




{"t":{"$date":"2022-07-09T19:40:28.058+05:30"},"s":"E",  "c":"CONTROL",  "id":20557,   "ctx":"initandlisten","msg":"DBException in initAndListen, terminating","attr":{"error":"NonExistentPath: Data directory C:\\data\\db\\ not found. Create the missing directory or specify another path using (1) the --dbpath command line option, or (2) by adding the 'storage.dbPath' option in the configuration file."}}


JSON will converted into BSON and stored.


Javascript only has 6 types:
String, Number, Object, Array, Boolean, Null



BSON:
Efficient Storage and Extro data types.

EJSON:
Extended JSON
At the time of Extention, EJSON will be displayed.


db is implicit object in MOngoDB


db.createCollection("<Name>")
db.collection.drop()
db.dropDatabase(); //Current DB will be deleted.
---


CRUD Operations:
db.getName()

// Default DB: test

1. CREATE

db.collection.insertOne()
db.collection.insertMany()
db.collection.insert()

> db.nitro.insertOne({
	eno:100,
	ename:"Sujith",
	esal:100.665,
	eddr:"Hyd" })

O/p:
{
        "acknowledged" : true,
        "insertedId" : ObjectId("62ca6d849c6bc0e0e11d914f")
}


READ:
-----

db.<collection>.findOne()


UPDATE:
-------
db.collection.updateOne()
db.collection.updateMany()
db.collection.replaceOne()


Test:

> db.vin.updateOne(
	{ename:"Sujith"},
	{sal:50000}
)

uncaught exception: Error: the update operation document must contain atomic operators.

atomic operators: $set

#1

> db.vin.updateOne( 
	{ename:"Sujith"},
	
	{$set :
		{sal:50000}
	} 
)

O/p:
{ "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }

Note: If anything prefexed with $ symbol, then it is predefined work in MongoDB.


Delete:
---------
db.collection.deleteOne(ename:"Vinney")

Ex:
> db.vin.deleteOne(
	{ename:"Sujith"}
)

Output:

{ "acknowledged" : true, "deletedCount" : 1 }


==============
Capped Collections:
Max: 1000 doucs
Size: 3736578 bytes


db.createCollection(name="")
db.createCollection(name, options)


>db.createCollection("testCap"
	{
		capped: true,
		size : 3736578,
		max:1000
	})
	
{ "ok" : 1 }


---
How to know a collection is capped or not?
How to change a collection to cappped collection?

What is Capped collections?
----

CRUD:

1. db.coll.insertOne()
2. db.coll.insertMany()
3. db.coll.insert()

1. db.coll.insertOne()
----------------------
db.coll.insertOne({...}) only one JSON Argument.

2. db.coll.insertMany([{},{},{},...])
-----------------------
Array of Objects as an Argument.


3. db.coll.insert({}) or db.coll.insert([{}])
To insert either a sngle doc or many of docs.


---
var emp = {}
emp.eno = 7777;
emp.ename = "Sujith";
emp.esal = 7777;
emp.eaddr = "HYD"

db.employees.insertOne(emp)
db.employees.insertMany([emp])
db.employees.insert([emp])

---

Commands are available in JS file?
Array of Docs available in JSON fiel?
Ordered Insertion
Nested Documents
Array to Documents
ObjectID

---

db.createCollection(<name>)
db.employees.drop()
db.createCollection(<name>,<options>)

<name>: Name of collection
<options>: JS Object, Document;

Doc properties:
size in bytes, no of max Docs, capped, 


db.createCollection("employees",{
	capped: true,
	size: 654464,
	max: 100
})


---
Inserting Docs from JS file also:
load(path of the file)


students.js
-----------
db.students.insertOne({...})
db.students.insertOne({...})
db.students.insertOne({...})

> load("D:\students.js")


------------

JSON file contains an array of JS objects:
mongoimport tool

in json file, the data should in array form.
Make sure the data should be of JSON

students.json
-------------
[
	{
		"name": "Sujith",
		"roll": 51
	},
	{
		"name": "Vineeth",
		"roll": 49
	},{
		"name": "Vamshi",
		"roll": 32
	},{
		"name": "Ajay",
		"roll": 1
	},{
		"name": "Divya",
		"roll": 29
	}
]

> Must use utility
mongod --> to start MongoDBServer
mongo  -->
mongoimport --> tool to import documents from json file into MongoDB.

Mongoimport is not available by default, we have to install utility.

GOTO: Try free -> Tools -> MongoDB DB tools -> download zip file.
Unzip and copy all files and paste into MongoDB bin folder.

mongoimport cmd should be execute from cmd, but not from Mongo shell.

DB name: studentsdb
Collections: students
GOTO: where the JSON file is located.
Syntax:
mongoimport --db databasename --collectionName --file fileName --jsonArray

Ex:
mongoimport --db studentsdb --collection students --file students.json  --jsonArray




json vs javascript object:
--------------------------
In JS obj, quote symbols for keys are optional.
But in JSON, quote symbols are mandatory for keys.


db.collection.insertOne(JS Object) // Quotes are optional.

------------------------------
MONGO_DB
------------------------------

Explain groups.$.users
In MongoDB, the positional operator ($) is used to update an element in an array based on its index or position.

In the context of the provided MongoDB record, groups.$.users represents the array of users within a specific group, where $ denotes the index or position of the matched element in the groups array.

For example, to update the second group's users with the ID 3030 and 3031, you can use the following query:

db.collection.update(
   { "groups.groupId": 2002 },
   { $set: { "groups.$.users": [3030, 3031, 3032, 3033] } }
)


db.getCollection('group_users').find({"groups.groupId" : 2001}, {"groups.$" : 1 })


db.getCollection('group_users').find({'groups' : { $exists : true} } )


db.getCollection('group_users').find(
{
        groups : { $exists : true}
}
)


db.getCollection('group_users').find(
{        'groups.groupId' : 2001 },
{        'groups.$' : 1 }
)


---
db.getCollection('case_details').find({
    priority : "Medium",
    status : "Open"
    }
 );
 
 
 db.getCollection('qa_audit').distinct("auditId" )
 
---
 
 db.getCollection('case_details').find(
    {
        priority : "Low",
        status : "Open",
        is_assigned : false
    },
    {  
        "case_id" : 1,
        "priority" : 1,
        "status" :1,
        "is_assigned" : 1
    }
 );
 
---
 
 db.movies.find( { countries: "Mexico", "imdb.rating": { $gte: 7 } } )
 
 ---
 db.movies.find( {
     year: 2010,
     $or: [ { "awards.wins": { $gte: 5 } }, { genres: "Drama" } ]
} )
---
 db.getCollection('agent_details').find(
    {
        status : "Active",
        first_name : {
             $regex :RegExp("du", 'i')
             }
    },
    {
        first_name : 1
    }
)
---
 db.getCollection('agent_details').find(
    {
        $or : [ 
       { status : "Active"},
   {
        first_name : {
             $regex :RegExp("du", 'i')
             }
         }
             
        ]
             
             
             },
    {
        first_name : 1
    }
)

---
 db.getCollection('agent_details').find(
    {
         status : "Active",
        $or : [ 
       
   {
        first_name : {
             $regex :RegExp("du", 'i')
             }
         }
         ,
         {mail_id : {$ne: null}}]
             
             
             }
)
---
 db.getCollection('agent_details').find( { first_name:{$regex : RegExp('Du','i')}})
---

### Sorting Query Results

public interface PersonRepository extends MongoRepository<Person, String> {

  List<Person> findByFirstnameSortByAgeDesc(String firstname); 

  List<Person> findByFirstname(String firstname, Sort sort);   

  @Query(sort = "{ age : -1 }")
  List<Person> findByFirstname(String firstname);              

  @Query(sort = "{ age : -1 }")
  List<Person> findByLastname(String lastname, Sort sort);     
}

---

### Sorting

{ age : -1, firstname : 1 }

---

### Queries with Predicate

public interface QuerydslPredicateExecutor<T> {

  T findOne(Predicate predicate);

  List<T> findAll(Predicate predicate);

  List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

  Page<T> findAll(Predicate predicate, Pageable pageable);

  Long count(Predicate predicate);
}


public interface PersonRepository extends MongoRepository<Person, String>, QuerydslPredicateExecutor<Person> {

   // additional query methods go here
}
 
---

## Projections

### A sample aggregate and repository

class Person {

  @Id UUID id;
  String firstname, lastname;
  Address address;

  static class Address {
    String zipCode, city, street;
  }
}

interface PersonRepository extends Repository<Person, UUID> {
  Collection<Person> findByLastname(String lastname);
}

### Interface-based Projections

> The important bit here is that the properties defined here exactly match properties in the aggregate root. 

interface NamesOnly {
  String getFirstname();
  String getLastname();
}

interface PersonRepository extends Repository<Person, UUID> {

  Collection<NamesOnly> findByLastname(String lastname);
}

---

### Spring Data Repositories



 
 
---

### Repository query keywords

[Click here](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories.namespace-reference)

query method subject keywords
find...By
exists...By
count...By
delete...By
Distinct


 
---

###  Repository query return types
[Click here](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories.namespace-reference)

Optional<T>
Stream<T>
Slice<T>
Page<T>


 
 
---

### Core concepts

> We also provide persistence technology-specific abstractions, such as JpaRepository or MongoRepository. Those interfaces extend CrudRepository and expose the capabilities of the underlying persistence technology in addition to the rather generic persistence technology-agnostic interfaces such as CrudRepository.
On top of the CrudRepository, there is a PagingAndSortingRepository abstraction that adds additional methods to ease paginated access to entities


public interface CrudRepository<T, ID> extends Repository<T, ID> {

  <S extends T> S save(S entity);      
  Optional<T> findById(ID primaryKey); 
  Iterable<T> findAll();               
  long count();                        
  void delete(T entity);               
  boolean existsById(ID primaryKey);   
  
  // … more functionality omitted.
}
 
---

### Pagging


```java
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {

  Iterable<T> findAll(Sort sort);

  Page<T> findAll(Pageable pageable);
}
```

PagingAndSortingRepository<User, Long> repository = // … get access to a bean
Page<User> users = repository.findAll(PageRequest.of(1, 20));
 
 
---

### Delete


interface UserRepository extends CrudRepository<User, Long> {

  long deleteByLastname(String lastname);
  List<User> removeByLastname(String lastname);
  
}
 
 
---

### Count

interface UserRepository extends CrudRepository<User, Long> {
  long countByLastname(String lastname);
}
 
 
---

###  Repositories with Multiple Spring Data Modules

interface MyRepository extends JpaRepository<User, Long> { }

@NoRepositoryBean
interface MyBaseRepository<T, ID> extends JpaRepository<T, ID> { … }

interface UserRepository extends MyBaseRepository<User, Long> { … }
 
---

### Defining Query Methods
The repository proxy has two ways to derive a store-specific query from the method name:

By deriving the query from the method name directly.

By using a manually defined query.

Available options depend on the actual store. However, there must be a strategy that decides what actual query is created. The next section describes the available options.

>Parsing query method names is divided into subject and predicate. The first part (find…By, exists…By) defines the subject of the query, the second part forms the predicate.

https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#appendix.query.method.subject
 
```java
interface PersonRepository extends Repository<Person, Long> {

  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

  // Enables the distinct flag for the query
  List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
  List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

  // Enabling ignoring case for an individual property
  List<Person> findByLastnameIgnoreCase(String lastname);
  // Enabling ignoring case for all suitable properties
  List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

  // Enabling static ORDER BY for a query
  List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
  List<Person> findByLastnameOrderByFirstnameDesc(String lastname);
}
```
 
---

### Property Expressions

class Person{
	Address address;
}

class Address{
	String street;
	Sring pincode;
}

List<Person> findByAddressStreet(String name);
List<Person> findByAddressPincode(String name);


---

### Special parameter handling

Page<User> findByLastname(String lastname, Pageable pageable);

Slice<User> findByLastname(String lastname, Pageable pageable);

List<User> findByLastname(String lastname, Sort sort);

List<User> findByLastname(String lastname, Pageable pageable);

 
---

### Limiting Query Results

User findFirstByOrderByLastnameAsc();

User findTopByOrderByAgeDesc();

Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

Slice<User> findTop3ByLastname(String lastname, Pageable pageable);

List<User> findFirst10ByLastname(String lastname, Sort sort);

List<User> findTop10ByLastname(String lastname, Pageable pageable);
 
---

### Using Streamable as Query Method Return Type

interface PersonRepository extends Repository<Person, Long> {
  Streamable<Person> findByFirstnameContaining(String firstname);
  Streamable<Person> findByLastnameContaining(String lastname);
}

Streamable<Person> result = repository.findByFirstnameContaining("av")
  .and(repository.findByLastnameContaining("ea"));

 
 
---

### Streamable Wrapper Types

class Product {                                         
  MonetaryAmount getPrice() { … }
}

@RequiredArgsConstructor(staticName = "of")
class Products implements Streamable<Product> {         

  private final Streamable<Product> streamable;

  public MonetaryAmount getTotal() {                    
    return streamable.stream()
      .map(Priced::getPrice)
      .reduce(Money.of(0), MonetaryAmount::add);
  }


  @Override
  public Iterator<Product> iterator() {                 
    return streamable.iterator();
  }
}

interface ProductRepository implements Repository<Product, Long> {
  Products findAllByDescriptionContaining(String text); 
}

 
 
---

### Null Handling of Repository Methods

package com.acme;                                                       

import org.springframework.lang.Nullable;

interface UserRepository extends Repository<User, Long> {

  User getByEmailAddress(EmailAddress emailAddress);                    

  @Nullable
  User findByEmailAddress(@Nullable EmailAddress emailAdress);          

  Optional<User> findOptionalByEmailAddress(EmailAddress emailAddress); 
}

 
 
---

### Streaming Query Results

@Query("select u from User u")
Stream<User> findAllByCustomQueryAndStream();

Stream<User> readAllByFirstnameNotNull();

@Query("select u from User u")
Stream<User> streamAllPaged(Pageable pageable);

 
 
---

### A fragment interface

interface CustomizedUserRepository {
  void someCustomMethod(User user);
}

class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

  public void someCustomMethod(User user) {
    // Your custom implementation
  }
}

interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository {
  // Declare query methods here
}

> The most important part of the class name that corresponds to the fragment interface is the Impl postfix.
---

### MongoDB Repositories

domain entities

 
 
---

### Repository Update Methods

Using update (as in updateAllByLastname(…​)) is allowed only in combination with @Query.

public interface PersonRepository extends CrudRepository<Person, String> {

  @Update("{ '$inc' : { 'visits' : 1 } }")
  long findAndIncrementVisitsByLastname(String lastname); 

  @Update("{ '$inc' : { 'visits' : ?1 } }")
  void findAndIncrementVisitsByLastname(String lastname, int increment); 

  @Update("{ '$inc' : { 'visits' : ?#{[1]} } }")
  long findAndIncrementVisitsUsingSpELByLastname(String lastname, int increment); 

  @Update(pipeline = {"{ '$set' : { 'visits' : { '$add' : [ '$visits', ?1 ] } } }"})
  void findAndIncrementVisitsViaPipelineByLastname(String lastname, int increment); 

  @Update("{ '$push' : { 'shippingAddresses' : ?1 } }")
  long findAndPushShippingAddressByEmail(String email, Address address); 

  @Query("{ 'lastname' : ?0 }")
  @Update("{ '$inc' : { 'visits' : ?1 } }")
  void updateAllByLastname(String lastname, int increment); 
}
 
---

### Repository Delete Queries

public interface PersonRepository extends MongoRepository<Person, String> {

  List <Person> deleteByLastname(String lastname);      

  Long deletePersonByLastname(String lastname);         

  @Nullable
  Person deleteSingleByLastname(String lastname);       

  Optional<Person> deleteByBirthdate(Date birthdate);   
}
 
---

### Field Restriction

public interface PersonRepository extends MongoRepository<Person, String> {

  @Query(value="{ 'firstname' : ?0 }", fields="{ 'firstname' : 1, 'lastname' : 1}")
  List<Person> findByThePersonsFirstname(String firstname);

}

 

---

### Sorting Query Results

public interface PersonRepository extends MongoRepository<Person, String> {

  List<Person> findByFirstnameSortByAgeDesc(String firstname); 

  List<Person> findByFirstname(String firstname, Sort sort);   

  @Query(sort = "{ age : -1 }")
  List<Person> findByFirstname(String firstname);              

  @Query(sort = "{ age : -1 }")
  List<Person> findByLastname(String lastname, Sort sort);     
}
 
---

### Projections

> The query execution engine creates proxy instances of that interface at runtime for each element returned and forwards calls to the exposed methods to the target object.

class Person {

  @Id UUID id;
  String firstname, lastname;
  Address address;

  static class Address {
    String zipCode, city, street;
  }
}

interface NamesOnly {
  String getFirstname();
  String getLastname();
}

interface PersonRepository extends Repository<Person, UUID> {
  Collection<NamesOnly> findByLastname(String lastname);
}

#### A closed projection

interface NamesOnly {

  String getFirstname();
  String getLastname();
}

#### An Open Projection

interface NamesOnly {

  @Value("#{target.firstname + ' ' + target.lastname}")
  String getFullName();
  …
}



---

### Class-based Projections (DTOs)

class NamesOnly {

  private final String firstname, lastname;

  NamesOnly(String firstname, String lastname) {

    this.firstname = firstname;
    this.lastname = lastname;
  }

  String getFirstname() {
    return this.firstname;
  }

  String getLastname() {
    return this.lastname;
  }

  // equals(…) and hashCode() implementations
}

@Value
class NamesOnly {
	String firstname, lastname;
}
 
---

### Dynamic Projections

interface PersonRepository extends Repository<Person, UUID> {

  <T> Collection<T> findByLastname(String lastname, Class<T> type);
}

void someMethod(PersonRepository people) {

  Collection<Person> aggregates =
    people.findByLastname("Matthews", Person.class);

  Collection<NamesOnly> aggregates =
    people.findByLastname("Matthews", NamesOnly.class);
}

 
 
---

### Aggregation Repository Methods


```java
public class PersonAggregate {

  private @Id String lastname;                                                     
  private List<String> names;

  public PersonAggregate(String lastname, List<String> names) {
     // ...
  }

  // Getter / Setter omitted
}
```

```java
public class SumValue {

  private final Long total;                                                         

  public SumValue(Long total) {
    // ...
  }

  // Getter omitted
}
```

```java
public interface PersonRepository extends CrudReppsitory<Person, String> {

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
  List<PersonAggregate> groupByLastnameAndFirstnames();                            

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
  List<PersonAggregate> groupByLastnameAndFirstnames(Sort sort);                   

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : ?0 } } }")
  List<PersonAggregate> groupByLastnameAnd(String property);                       

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : ?0 } } }")
  Slice<PersonAggregate> groupByLastnameAnd(String property, Pageable page);       

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
  Stream<PersonAggregate> groupByLastnameAndFirstnamesAsStream();                  

  @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
  SumValue sumAgeUsingValueWrapper();                                              

  @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
  Long sumAge();                                                                   

  @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
  AggregationResults<SumValue> sumAgeRaw();                                        

  @Aggregation("{ '$project': { '_id' : '$lastname' } }")
  List<String> findAllLastnames();                                                 
}
```

---

### FIND Queries

db.getCollection('agent_details').find({_id :ObjectId("6184fdcc68b51a7ad0cff7a9")},{_id : 1, first_name : 1})
 
> Selects documents in a collection or view and returns a cursor to the selected documents.
A pointer to the result set of a 
query
. Clients can iterate through a cursor to retrieve results. By default, cursors not opened within a session automatically timeout after 10 minutes of inactivity. Cursors opened under a session close with the end or timeout of the session.

find({query}, {projection}, {options})

> Query operators provide ways to locate data within the database and projection operators modify how data is presented.
https://www.mongodb.com/docs/manual/reference/operator/query/

> With the use of the $ array projection operator, you can specify the projection to return the first element that match the query condition on the array field; e.g. "arrayField.$" : 1. (Not available for views.) Non-zero integers are also treated as true.


> Returns:	A cursor to the documents that match the query criteria. When the 
find()
 method "returns documents," the method is actually returning a cursor to the documents.
 
> Unless the _id field is explicitly excluded in the projection document _id: 0, the _id field is returned.

db.bios.find( { }, { name: 1, contribs: 1 } )

db.bios.find(
   { },
   { name: 1, contribs: 1, _id: 0 }
)

db.bios.find(
   { },
   { _id: 0, name: { last: 1 }, contribs: { $slice: 2 } }
)

db.getCollection('case_details').find({status : "Closed", priority : "Low"},{status : 1, priority : 1,case_id: 1},{case_id :   1})
---

### Cursor Methods

db.getCollection('case_details').find(
    {status : "Closed", priority : "Low"},
    {status : 1, priority : 1,case_id: 1}
).skip(10).limit(5).sort({case_id : -1});

size()
skip()
sort()
limit()
pretty()
count()
sort()
explain()

db.getCollection('agent_details').find({first_name : {$regex : RegExp("Dur","i")}}).count()
 
 
---

### Query Selectors

 
 
---

### Create MongoDB

db.createCollection( <name>)


db.inventory.insertMany(
   [
        { _id: 1, item: { name: "ab", code: "123" }, qty: 15, tags: [ "A", "B", "C" ] },
		{ _id: 2, item: { name: "cd", code: "123" }, qty: 20, tags: [ "B" ] },
		{ _id: 3, item: { name: "ij", code: "456" }, qty: 25, tags: [ "A", "D" ] },
		{ _id: 4, item: { name: "xy", code: "456" }, qty: 30, tags: [ "B", "A" ] },
		{ _id: 5, item: { name: "mn", code: "000" }, qty: 20, tags: [  "A", "E" , "C" ] }
   ]
)


// db.inventory.find( { "item.name" : "cd" } );
// db.inventory.find( { tags : "C" } );
// db.inventory.find( { tags :{$in : ["D","E"] }} );
// db.inventory.find( { "item.code" : "000"} );
// db.inventory.find( { "item.name" : "mn"} );
// db.inventory.find({ _id : 1,"item.name" : "ab"});
// db.inventory.find({ _id : 1,"item.name" : "ab", qty: 15});
// db.inventory.find({ $or : [ { _id : 1} ,{"item.name" : "cd"},{ qty: 30} ]});
// db.inventory.find({ $or : [ { _id : 1} ,{"item.name" : "cd"},{ qty: 30} ]}).count();
// db.inventory.find({ $or : [ { _id : 1} ,{"item.name" : "cd"},{ qty: 30} ]},{_id : 1});
// db.inventory.find({ $or : [ { _id : 1} ,{"item.name" : "cd"},{ qty: 30} ]},{_id : 1}).sort(_id : 1);
// db.inventory.find({ $or : [ { _id : 1} ,{"item.name" : "cd"},{ qty: 30} ]},{_id : 0});
// db.inventory.find({$not : { $or : [ { _id : 1} ,{"item.name" : "cd"},{ qty: 30} ]}});
// db.inventory.find(  {"item.name" : {$not : { $regex  : RegExp("x","i")}} }, {_id : 1});


db.inventory.find(
    {      
        // tags : { $eq : "E"} // All items which contains E element.
        // tags : { $in : ["E", "C"]} // All items which contains E or C element.
        // tags : { $eq : ["E", "C"]} // Check whether contains pair of tags.
        // tags : { $all : ["E", "C"]} // If both tags are present.
        // tags : { $all : ["B", "E"]}
        // tags : { $elemMatch: {"A"}}
    }
);
 
---

### Array Operators

db.inventory.insertMany(
    [
        { _id: 1, results: [ 82, 85, 88 ] },
        { _id: 2, results: [ 75, 88, 89 ] },
        { _id: 3, results: [ 100, 82, 59 ] }
    ]
);

db.inventory.find(
    {
      // results : 88 // Search if contains at least one element
      // results : { $in : [59,82]} // Finds collections which contains 59 or 82.
      // results : { $all : [59,82]} // Finds collections which contains 59 and 82.
    }
);

 
 
---

### How do I perform the SQL Join equivalent in MongoDB

db.dept.insertMany([
    
    { _id: 1, name : "IT" },
    { _id: 2, name : "HR" },
    { _id: 3, name : "SALES" }
    ]);

// db.dept.find({ });

db.employees.insertMany([
  { _id: 1, name: 'Ryan', gender: 'M', dept: {"$ref" : "dept", "$id" : 1} },
  { _id: 2, name: 'Joanna', gender: 'F', dept: {"$ref" : "dept", "$id" : 2} },
  { _id: 3, name: 'Joanna', gender: 'F', dept: {"$ref" : "dept", "$id" : 2} }

]);

// db.employees.find({ });

// db.employees.find({ "dept.$id" : 1 });
db.employees.find({ "dept.$id" : 2 });





 
---

### JOIN Tables

db.orders.insertMany( [
   { "_id" : 1, "item" : "almonds", "price" : 12, "quantity" : 2 },
   { "_id" : 2, "item" : "pecans", "price" : 20, "quantity" : 1 },
   { "_id" : 3  }
] );

db.inventory.insertMany( [
   { "_id" : 1, "sku" : "almonds", "description": "product 1", "instock" : 120 },
   { "_id" : 2, "sku" : "bread", "description": "product 2", "instock" : 80 },
   { "_id" : 3, "sku" : "cashews", "description": "product 3", "instock" : 60 },
   { "_id" : 4, "sku" : "pecans", "description": "product 4", "instock" : 70 },
   { "_id" : 5, "sku": null, "description": "Incomplete" },
   { "_id" : 6 }
] );

// db.orders.find();
// db.inventory.find();

db.orders.aggregate( [
   {
     $lookup:
       {
         from: "inventory",
         localField: "item",
         foreignField: "sku",
         as: "inventory_docs"
       }
  }
] )

 
 
---

### Create Collection

db.createCollection(name, options)
https://www.tutorialspoint.com/mongodb/mongodb_create_collection.htm

capped
autoIndexId
size
max

> db.createCollection("mycollection")

> db.createCollection("mycol", { capped : true, autoIndexID : true, size : 6142800, max : 10000 } )
 
You don't need to create collection. MongoDB creates collection automatically, when you insert some document.
> db.tutorialspoint.insert({"name" : "tutorialspoint"})

> db.COLLECTION_NAME.drop()

> db.mycollection.drop()
> db.COLLECTION_NAME.insert(document)

> db.post.insert([...])

> db.empDetails.insertOne()
> db.empDetails.insertMany()

> db.COLLECTION_NAME.find()

> db.COLLECTION_NAME.find().pretty()

> db.COLLECTIONNAME.findOne()

> db.mycol.findOne({title: "MongoDB Overview"})

> db.mycol.find({ $and: [ {<key1>:<value1>}, { <key2>:<value2>} ] })
> db.mycol.find({$and:[{"by":"tutorials point"},{"title": "MongoDB Overview"}]}).pretty()

>db.mycol.find(
   {
      $or: [
         {key1: value1}, {key2:value2}
      ]
   }
).pretty()


> db.mycol.find({"likes": {$gt:10}, $or: [{"by": "tutorials point"},
   {"title": "MongoDB Overview"}]}).pretty()

> db.COLLECTION_NAME.find(
	{
		$not: [
			{key1: value1}, {key2:value2}
		]
	}
)

> db.empDetails.find(
	{
		$nor:[
			40
			{"First_Name": "Radhika"},
			{"Last_Name": "Christopher"}
		]
	}
).pretty()


> db.COLLECTION_NAME.find(
	{
		$NOT: [
			{key1: value1}, {key2:value2}
		]
	}
).pretty()


---

### Update()

> db.COLLECTION_NAME.update(SELECTION_CRITERIA, UPDATED_DATA)
> db.mycol.update({'title':'MongoDB Overview'},{$set:{'title':'New MongoDB Tutorial'}})
 
By default, MongoDB will update only a single document. To update multiple documents, you need to set a parameter 'multi' to true.

>db.mycol.update({'title':'MongoDB Overview'},
   {$set:{'title':'New MongoDB Tutorial'}},{multi:true})
---

### Save()

The save() method replaces the existing document with the new document passed in the save() method.

> db.COLLECTION_NAME.save({_id:ObjectId(),NEW_DATA})

> db.COLLECTION_NAME.findOneAndUpdate(SELECTIOIN_CRITERIA, UPDATED_DATA)

> db.empDetails.findOneAndUpdate(
	{First_Name: 'Radhika'},
	{ $set: { Age: '30',e_mail: 'radhika_newemail@gmail.com'}}
)

> db.COLLECTION_NAME.updateOne(<filter>, <update>)

> db.COLLECTION_NAME.updateMany(<filter>, <update>)


---

### remove()

> db.COLLECTION_NAME.remove(DELLETION_CRITTERIA)
> db.mycol.remove({'title':'MongoDB Overview'})


Remove All Documents
If you don't specify deletion criteria, then MongoDB will delete whole documents from the collection. This is equivalent of SQL's truncate command.

> db.COLLECTION_NAME.remove(DELETION_CRITERIA,1)
---

### Projection

>db.COLLECTION_NAME.find({},{KEY:1})
 
 
---

### MongoDB - Indexing

Indexes support the efficient resolution of queries. Without indexes, MongoDB must scan every document of a collection to select those documents that match the query statement. This scan is highly inefficient and require MongoDB to process a large volume of data.

Indexes are special data structures, that store a small portion of the data set in an easy-to-traverse form. The index stores the value of a specific field or set of fields, ordered by the value of the field as specified in the index.


> db.COLLECTION_NAME.createIndex({KEY:1})

Here key is the name of the field on which you want to create index and 1 is for ascending order. To create index in descending order you need to use -1. 	

> db.mycol.createIndex({"title":1,"description":-1})
 
> db.COLLECTION_NAME.dropIndex({KEY:1})

db.COLLECTION_NAME.getIndexes()
---

### Aggregation

Following are the possible stages in aggregation framework −

$project − Used to select some specific fields from a collection.

$match − This is a filtering operation and thus this can reduce the amount of documents that are given as input to the next stage.

$group − This does the actual aggregation as discussed above.

$sort − Sorts the documents.

$skip − With this, it is possible to skip forward in the list of documents for a given amount of documents.

$limit − This limits the amount of documents to look at, by the given number starting from the current positions.

$unwind − This is used to unwind document that are using arrays. When using an array, the data is kind of pre-joined and this operation will be undone with this to have individual documents again. Thus with this stage we will increase the amount of documents for the next stage.
 
 
Expression
$sum, $avg, $min, $max, $push, $first, $last

---

MongoDB
-------
@Query("{'product_name' : ?0}")
ProductModel findProductByProductName(String productname);


Keywords:
Gradle is a build automation system
	
	
Exception Handling

There are three options: per exception, per controller or globally.

1. Using HTTP Status Codes

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
	public class OrderNotFoundException extends RuntimeException {
		// ...
	}

2. 

HttpServletRequest, HttpServletResponse, HttpSession and/or Principle


3. ExceptionHandlerExceptionResolver


MONGO DB
--------

Relationships in MongoDB represent how various documents are logically related to each other. Relationships can be modeled via Embedded and Referenced approaches
 
1. Modeling Embedded Relationships
2. Referenced approaches


> var result = db.users.findOne({"name":"Tom Benzamin"},{"address_ids":1})
> var addresses = db.address.find({"_id":{"$in":result["address_ids"]}})

1. Referenced Relationships
2. Manual References 

Using DBRefs
There are three fields in DBRefs −

$ref − This field specifies the collection of the referenced document
$id − This field specifies the _id field of the referenced document
$db − This is an optional field and contains the name of the database in which the referenced document lies
---

### Aggregate

public interface PersonRepository extends CrudReppsitory<Person, String> {

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
  List<PersonAggregate> groupByLastnameAndFirstnames();                            

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
  List<PersonAggregate> groupByLastnameAndFirstnames(Sort sort);                   

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : ?0 } } }")
  List<PersonAggregate> groupByLastnameAnd(String property);                       

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : ?0 } } }")
  Slice<PersonAggregate> groupByLastnameAnd(String property, Pageable page);       

  @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
  Stream<PersonAggregate> groupByLastnameAndFirstnamesAsStream();                  

  @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
  SumValue sumAgeUsingValueWrapper();                                              

  @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
  Long sumAge();                                                                   

  @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
  AggregationResults<SumValue> sumAgeRaw();                                        

  @Aggregation("{ '$project': { '_id' : '$lastname' } }")
  List<String> findAllLastnames();                                                 
}

public class PersonAggregate {

  private @Id String lastname;                                                     
  private List<String> names;

  public PersonAggregate(String lastname, List<String> names) {
     // ...
  }

  // Getter / Setter omitted
}

public class SumValue {

  private final Long total;                                                         

  public SumValue(Long total) {
    // ...
  }

  // Getter omitted
}
 
 
---

### Auditing

We provide @CreatedBy and @LastModifiedBy to capture the user who created or modified the entity as well as @CreatedDate and @LastModifiedDate to capture when the change happened.
 
 
class Customer {

  @CreatedBy
  private User user;

  @CreatedDate
  private Instant createdDate;

  // … further properties omitted
}
 
 
 
Audit metadata in embedded entity
class Customer {

  private AuditMetadata auditingMetadata;

  // … further properties omitted
}

class AuditMetadata {

  @CreatedBy
  private User user;

  @CreatedDate
  private Instant createdDate;

}


@Configuration
@EnableMongoAuditing
class Config {

  @Bean
  public AuditorAware<AuditableUser> myAuditorProvider() {
      return new AuditorAwareImpl();
  }
}
---

### Title

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOptions;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update; 
 
---

### Title

https://mkyong.com/mongodb/spring-data-mongodb-aggregation-grouping-example/

https://www.baeldung.com/spring-data-mongodb-projections-aggregations#:~:text=Aggregation,-Aggregation%20in%20MongoDB&text=Spring%20Data%20MongoDB%20provides%20an,the%20result%20produced%20by%20aggregation.



 
---

### Title

db.orders.aggregate( [
   {
      $lookup: {
         from: "items",
         localField: "item",    // field in the orders collection
         foreignField: "item",  // field in the items collection
         as: "fromItems",
         pipeline: [{
            $project : {items_name : "$item"}
         }]
      }
   },
   {
      $replaceRoot: { newRoot: { $mergeObjects: [ { $arrayElemAt: [ "$fromItems", 0 ] }, "$$ROOT" ] } }
   },
   { $project: { fromItems: 0 } }
] )


---


db.orders.aggregate( [
   {
      $lookup: {
         from: "items",
         localField: "item",    // field in the orders collection
         foreignField: "item",  // field in the items collection
         as: "fromItems",
         pipeline: [{
            $project : {instock : "$instock"}
         }]
      }
   },
   {
      $replaceRoot: { newRoot: { $mergeObjects: [ { $arrayElemAt: [ "$fromItems", 0 ] }, "$$ROOT" ] } }
   },
   { $project: { fromItems: 0 } }
] )


 
 
---

### Aggregation Accumulator


$count
 
 
---

### Title

db.getCollection("employees").aggregate([
{
    $group : { _id : '$job', count : {$sum : 1}  }
}
])
 
 
---

### Expression Operators

{ <operator>: [ <argument1>, <argument2> ... ] }

1. $add[...]
2. $divide[a,b]
3. $mod[a,b]
4. $multiply[...]
5. $pow[p]
6. $subtract[a,b]
7. $dateToString Returns the date as a formatted string.
8. $ifNull
9. $toString
10. $$NOW

#7

db.getCollection("employees").aggregate([
    {

        $project: {
            _id: 0,
            firstName: 1,
            date: {
                $dateToString: {
                    date: '$hiredate',
                    format: '%d/%m/%G %H:%M:%S',
                }
            }
        }
    }
])

db.getCollection("employees").aggregate([
    {

        $project: {
            _id: 0,
            firstName: 1,
            date: {
                $dateToString: {
                    date: null,
                    format: '%d/%m/%G %H:%M:%S',
                    onNull: 'Date not found'
                }
            }
        }
    }
])

db.getCollection("employees").aggregate([
    {

        $project: {
            _id: 0,
            firstName: 1,
            date1 : '$hiredate',
            date: {
                $dateAdd: {
                    startDate: '$hiredate',
                    unit: 'day',
                    amount: 7
                }
            }
        }
    }
])


#8

test : { $add : [ { $ifNull : [2, 0] }] }





db.getCollection("employees").aggregate([
{
    
    $project :{
        beforeSal : { $add : ['$salary']},   
        afterSal : { $add : ['$salary' , 2132321]}
    }
}
])

 
 
---

### Query Documents

db.getCollection("employees").find({ 'job' : {$in : ['JavaSE','Manager']}, salary : {$gte : 50000}})

Type Bracketing

$in x $nin
$eq x $ne
$lt x $gt
$lte x $gte

{ $not: { $regex: /^p.*/ } }
db.getCollection("employees").find({ $or : [ {'job' : {$in : ['JavaSE']} }, {salary : {$gte : 90000}} ]})

$nor should not match any condition.
$and should match all the conditions
$or should match any condition

$and x $nor


 
 
---

### Title

db.getCollection("demo").insertMany([
{ a: 5, b: 5, c: null },
{ a: 3, b: null, c: 8 },
{ a: null, b: 3, c: 9 },
{ a: 1, b: 2, c: 3 },
{ a: 2, c: 5 },
{ a: 3, b: 2 },
{ a: 4 },
{ b: 2, c: 4 },
{ b: 2 },
{ c: 6 },
])


db.getCollection("demo").find({}) // Empty and Nulls

db.getCollection("demo").find({c : {$gte : 0}}) // Only values

db.getCollection("demo").find({c : { $eq: null}}) // Gives null and Empty

db.getCollection("demo").find({c : {$exists : true}}) // Gives null and Values, avoids empty.

db.getCollection("demo").find({c : {$exists : false}}) // Gives only empty.

db.getCollection("demo").find({c : {$ne : null}}) // Gives only values
 
---

### MONGO DB Array

db.notes.insertMany([
{tages :['A','B','C','D']},
{tages :['A','B']},
{tages :['C','D']},
{tages :['B','C']},
{tages :['A','E','F']},
{tages :['B','D','E']},
{tages :['A']},
{tages :['B']}
])
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 

---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---

### Title

 
 
---