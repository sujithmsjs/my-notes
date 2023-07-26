### 1. Spring Data's built-in suppor


```java
Page<User> findAll(Pageable pageable);

Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
return userRepository.findAll(pageable);
```

### 2. Query object


```java
Page<YourEntity> findAll(Query query, Pageable pageable);
```


### 3. MongoOperations

```java
Query query = new Query(Criteria.where(field).is(value));
return mongoOperations.find(query, Document.class, collectionName);
```


### 4. MongoTemplate

```java
Query query = new Query();
query.addCriteria(Criteria.where("field").is(criteria));
query.with(pageable);
query.with(sort);
return mongoTemplate.find(query, YourEntity.class);


Query query = new Query().with(PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
List<User> users = mongoTemplate.find(query, User.class);
long count = mongoTemplate.count(query, User.class);
return new PageImpl<>(users, PageRequest.of(pageNo, pageSize), count);
```

### 5. Using Custom Query Methods

```java

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByCriteria(String criteria, Pageable pageable, Sort sort);
}

public class UserController {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByCriteria(String criteria, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return userRepository.findByCriteria(criteria, pageable, Sort.by(sortBy));
    }
}


```

### 6. Aggregation Framework

> Aggregation is a MongoDB framework that allows us to perform data processing operations like filtering, grouping, and sorting on MongoDB collections.

```java
@Autowired
private MongoTemplate mongoTemplate;

public List<User> getAllUsers(int pageNo, int pageSize, String sortBy) {
    Aggregation aggregation = Aggregation.newAggregation(
        Aggregation.sort(Sort.by(sortBy)),
        Aggregation.skip(pageNo * pageSize),
        Aggregation.limit(pageSize)
    );
    AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class, User.class);
    return results.getMappedResults();
}
```

---
# Find By Types

1. Derived Query Methods
2. MongoTemplate
3. MongoOperations
4. @Aggregation annotation
5. Aggregation Framework


### 1. Derived Query Methods
```java
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
```

### 2. MongoTemplate
```java
@Autowired
private MongoTemplate mongoTemplate;

public User getUserByEmail(String email) {
    Query query = new Query(Criteria.where("email").is(email));
    return mongoTemplate.findOne(query, User.class);
}
```

### 3. MongoOperations
```java
@Autowired
private MongoOperations mongoOperations;

public User getUserByEmail(String email) {
    Query query = new Query(Criteria.where("email").is(email));
    return mongoOperations.findOne(query, User.class);
}
```

### 4. @Aggregation annotation
```java
@Aggregation(pipeline = {
    "{ $match: { email: ?0 } }",
    "{ $limit: 1 }"
})
User findUserByEmail(String email);
```

### 5. Aggregation Framework
```java
@Autowired
private MongoTemplate mongoTemplate;

public User getUserByEmail(String email) {
    Aggregation aggregation = Aggregation.newAggregation(
        Aggregation.match(Criteria.where("email").is(email)),
        Aggregation.limit(1)
    );
    AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class, User.class);
    List<User> users = results.getMappedResults();
    return users.isEmpty() ? null : users.get(0);
}
```
### 5. Using Criteria

```java
Criteria criteria1 = Criteria.where("field1").is(value1);
Criteria criteria2 = Criteria.where("field2").is(value2);
Criteria combinedCriteria = new Criteria().andOperator(criteria1, criteria2);

Query query = new Query(combinedCriteria);
List<Document> documents = mongoTemplate.find(query, Document.class, "collectionName");
```
---
# Updation Types

> The disadvantage with the save() method is that we always have to provide the whole Document object as an input parameter even if we want to update only 1 or 2 fields out of 20 fields. Meaning the save() method does not allow delta updates.

> Note: It is not possible to update a record using the Aggregation API in MongoDB.
 The Aggregation API is used to perform complex data manipulations and transformations on MongoDB collections. It is primarily used to retrieve and analyze data from collections using various pipeline stages such as $match, $group, $sort, and many more.

> Delta Update: Delta update refers to a technique used in database management to update only the changes made to a data record, rather than updating the entire record. Delta updates can help reduce the amount of data that needs to be updated, which can save time and reduce the risk of data inconsistencies or conflicts.

### 1. Update using JPQL


> You can use the @Query annotation with a JPQL update statement to update a document in MongoDB using a Spring Data MongoDB repository.

```java
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);

    @Modifying
    @Query("update User u set u.email = :newEmail where u.email = :oldEmail")
    void updateEmail(@Param("oldEmail") String oldEmail, @Param("newEmail") String newEmail);
}
```
### 2. Update using MongoTemplate
```java
@Autowired
private MongoTemplate mongoTemplate;

public void updateEmail(String oldEmail, String newEmail) {
    Query query = new Query(Criteria.where("email").is(oldEmail));
    Update update = new Update().set("email", newEmail);
    
    mongoTemplate.updateFirst(query, update, User.class);
    // or
    mongoOperations.updateMulti(query, update, User.class);
}
```
### 3. Update using MongoOperations
```java
@Autowired
private MongoOperations mongoOperations;

public void updateEmail(String oldEmail, String newEmail) {
    Query query = new Query(Criteria.where("email").is(oldEmail));
    Update update = new Update().set("email", newEmail);
    mongoOperations.updateFirst(query, update, User.class);
}
```
### 4. Update using Derived Query methods
> Note that derived query methods can only perform simple update operations. If you need to perform more complex update operations, such as using a $set operation or updating multiple fields at once, you'll need to use the MongoTemplate or MongoOperations interfaces instead.

```java
public interface UserRepository extends MongoRepository<User, String> {
    void updateByEmail(String email, String newEmail);
}
```
### 5. Update using Find And Modify
```java
Query query = new Query(Criteria.where("_id").is(id));
Update update = new Update().set("field1", value1).set("field2", value2);
Document modifiedDocument = mongoTemplate.findAndModify(query, update, options().returnNew(true), Document.class, "collectionName");
```


---

# Possible ways to delete a record

1. CrudRepository delete method
2. MongoTemplate remove method
3. Derived Query Methods
4. MongoOperations remove method
5. MongoTemplate findAndRemove
6. MongoOperations findAndRemove
7. Using MongoTemplate.remove with WriteConcern
8. Using MongoOperations.remove with WriteConcern

### 1. CrudRepository delete method
```java
myRepository.delete(myRecord);
```
### 2. MongoTemplate remove method
```java
Query query = new Query(Criteria.where("field1").is("value1"));
DeleteResult result = mongoTemplate.remove(query, MyRecord.class);
long numDeleted = result.getDeletedCount();
```
### 3. Using @Query annotation:
```java
@Query("{'field1': ?0}")
void deleteByField1(String field1);

@Query("{'$or':[{'email':?0},{'firstName':?0},{'lastName':?0}]}")
void deleteByEmailOrFirstNameOrLastName(String value);
```
### 4. MongoOperations remove method
```java
Query query = new Query(Criteria.where("field1").is("value1"));
mongoOperations.remove(query, MyRecord.class);
```
### 5. MongoTemplate findAndRemove
```java
Query query = new Query(Criteria.where("field1").is("value1"));
MyRecord deletedRecord = mongoTemplate.findAndRemove(query, MyRecord.class);
```
### 6. MongoOperations findAndRemove
```java
Query query = new Query(Criteria.where("field1").is("value1"));
MyRecord deletedRecord = mongoOperations.findAndRemove(query, MyRecord.class);
```
### 7. Using MongoTemplate.remove with WriteConcern
```java
Query query = new Query(Criteria.where("field1").is("value1"));
WriteConcern writeConcern = new WriteConcern(1);
mongoTemplate.remove(query, MyRecord.class, writeConcern);
```
### 8. Using MongoOperations.remove with WriteConcern
```java
Query query = new Query(Criteria.where("field1").is("value1"));
WriteConcern writeConcern = new WriteConcern(1);
mongoOperations.remove(query, MyRecord.class, writeConcern);
```
### 9. Using Derived Query Methods
```java
public interface MyRepository extends MongoRepository<MyRecord, String> {

    // delete documents by email
    void deleteByEmail(String email);

    // delete documents by age greater than
    void deleteByAgeGreaterThan(int age);

    // delete documents by age between
    void deleteByAgeBetween(int minAge, int maxAge);

    // delete documents by first name ignoring case
    void deleteByFirstNameIgnoreCase(String firstName);

    // delete documents by last name and age
    void deleteByLastNameAndAge(String lastName, int age);

    // delete documents by last name or age
    void deleteByLastNameOrAge(String lastName, int age);

    // delete documents by using a custom query
    @Query("{'email': {$regex : ?0, $options: 'i'}}")
    void deleteByEmailRegex(String emailRegex);
}
```



















