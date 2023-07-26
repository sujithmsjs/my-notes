# MongoDB Turotial Point

### MongoDB

> MongoDB is a cross-platform, document oriented database that provides, high performance, high availability, and easy scalability. MongoDB works on concept of collection and doacument.


### Database

Database is a physical container for collections. Each database gets its own set of files on the file system. A single MongoDB server typically has multiple databases.

### Collection

Collection is a group of MongoDB documents. It is the equivalent of an RDBMS table. A collection exists within a single database. Collections do not enforce a schema. Documents within a collection can have different fields. Typically, all documents in a collection are of similar or related purpose.


### Document

A document is a set of key-value pairs. Documents have dynamic schema. Dynamic schema means that documents in the same collection do not need to have the same set of fields or structure, and common fields in a collection's documents may hold different types of data.

### Terminology

|RDBMS|MongoDB|
|-----|-------|
|Database|Database|
|Table|Collection|
|Tuple/Row|Document|
|column|Field|
|Table Join|Embedded Documents|


### Aboud _id

If you don’t provide an ID then MongoDB provides a unique id for every document. These 12 bytes first 4 bytes for the current timestamp, next 3 bytes for machine id, next 2 bytes for process id of MongoDB server and remaining 3 bytes are simple incremental VALUE.

|Elements|Bytes|
|-------|-----|
|Current Timestamp|4|
|Machine ID|3|
|Process Id|3|
|Simple Incremental VALUE |4|

> ***Note***
Any relational database has a typical schema design that shows number of tables and the relationship between these tables. While in MongoDB, there is no concept of relationship.

### Advantages of MongoDB over RDBMS

- Schema less
- Structure of a single object is clear.
- No complex joins.
- Deep query-ability.
- Tuning
- Ease of scale-out
- Conversion/mapping of application objects to database objects not needed.
- Uses internal memory for storing the (windowed) working set, enabling faster access of data.
- 
### Why Use MongoDB?

- Document Oriented Storage − Data is stored in the form of JSON style documents.
- Index on any attribute
- Replication and high availability
- Auto-Sharding
- Rich queries
- Fast in-place updates
- Professional support by MongoDB


[MongoDB - Advantages](https://www.tutorialspoint.com/mongodb/mongodb_advantages.htm) 

# MongoDB - Data Modelling

> ### Data Model Design
> MongoDB provides two types of data models
> 1. Embedded data model
> 2. Normalized data model

### 1. Embedded Data Model
In this model, all the related data in a single document, it is also known as **de-normalized data model**.

### 2. Normalized Data Model
In this model, you can refer the sub documents in the original document, using **references**.

|pid|name|
|--|----|
| 1| Sujith|
| 2| Vineeth|
| 3| Vishlesh|

|aid|name|
|--|----|
| 1| SBI|
| 2| HDFC|
| 3| ICICI|

























