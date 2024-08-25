MongoDB
-------
MongoDB is a NoSQL database that stores data in flexible JSON-like documents and is known for its scalability, performance, and schema flexibility.

- It falls under the category of NoSQL databases, meaning it diverges from traditional relational database models.
- MongoDB stores data in flexible, JSON-like documents called BSON.
- It's known for its scalability, flexibility, and performance.
- MongoDB is often used in applications where there is a need to handle large volumes of unstructured or semi-structured data.
- It's commonly used in web development, mobile applications, and other scenarios requiring agile and scalable data storage solutions.
- MongoDB supports features such as high availability, horizontal scalability, and automatic sharding.
- It provides a rich ecosystem of tools and integrations for efficient data management and development.
- MongoDB is widely adopted by developers and organizations due to its ease of use and powerful capabilities in handling diverse data types and workloads.

Key features and advantages
---------------------------
Flexible Schema
BSON Format
Scalability
High Performance
Rich Query Language
Document-Oriented Storage
Automatic Failover and Replication
Horizontal Scaling
Rich Ecosystem and Tools
Adoption in Various Industries
Community and Support


How Data is Stored in MongoDB
-----------------------------
In MongoDB, data is stored in a flexible and schema-less manner using a format called BSON (Binary JSON). 

BSON Format: MongoDB uses BSON (Binary JSON) as its internal storage format. BSON extends the JSON format to include additional data types such as Date, Binary Data, and ObjectId. This binary encoding makes BSON more efficient for storage and data manipulation compared to plain JSON.

JSON will converted into BSON and stored.

Javascript only has 6 types:
String, Number, Object, Array, Boolean, Null

BSON:
Efficient Storage and Extro data types.

EJSON:
Extended JSON
At the time of Extention, EJSON will be displayed.


db is implicit object in MOngoDB

Relational Database vs Document Database
----------------------------------------


MongoDB v/s MySQL
-----------------


MONGO-DB STRUCURE
-----------------
- Physical databases reside on the storage medium (disk) of the server where MongoDB is installed. Each physical database contains several logical databases.
- Logical databases are a way to logically group and separate different sets of data within the same physical database.
- A collection is a grouping of MongoDB documents. Collections are analogous to tables in relational databases. However, unlike tables, collections do not enforce a schema, allowing documents within the same collection to have different structures.
- A document is a JSON-like data structure composed of key-value pairs. Documents are the basic unit of data in MongoDB, similar to rows in a table in relational databases. However, MongoDB's documents are schema-less, meaning different documents within the same collection can have different fields and structures.


Mysql     - MongoDB
-----------------------
Table     - Collection
Rows      - Documents
Columns   - Fields







