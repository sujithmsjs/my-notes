# JPQL

```java
@Indexed
public interface Repository<T, ID> {
}
```

```java
@NoRepositoryBean
public interface CrudRepository<T, ID> extends Repository<T, ID> {

    // Save Methods
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    
    // Find Methods
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<ID> ids);
   
    // Exists Methods
    boolean existsById(ID id);
    
    // Count Methods
    long count();
    
    // Delete Methods
    void deleteById(ID id);
    void delete(T entity);
    void deleteAllById(Iterable<? extends ID> ids);
    void deleteAll(Iterable<? extends T> entities);
    void deleteAll();
}
```


```java
@NoRepositoryBean
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAll(Sort sort);
    Page<T> findAll(Pageable pageable);
}
```


```java
public interface QueryByExampleExecutor<T> {
    <S extends T> Optional<S> findOne(Example<S> var1);
    <S extends T> Iterable<S> findAll(Example<S> var1);
    <S extends T> Iterable<S> findAll(Example<S> var1, Sort var2);
    <S extends T> Page<S> findAll(Example<S> var1, Pageable var2);
    <S extends T> long count(Example<S> var1);
    <S extends T> boolean exists(Example<S> var1);
}
```

```java
public interface JpaRepository<T, ID>
  extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
      
  }
```
# Native
```java
@Query(
  value = "SELECT * FROM Users ORDER BY id", 
  countQuery = "SELECT count(*) FROM Users", 
  nativeQuery = true)
Page<User> findAllUsersWithPagination(Pageable pageable);
```

# DERIVED QUERIES AND JPQL
Resources
 [baeldung](https://www.baeldung.com/spring-data-jpa-query)
 [javaguides](https://www.javaguides.net/2018/11/spring-data-jpa-query-creation-from-method-names.html)

### Select All
```java
@Query("SELECT u FROM User u WHERE u.status = 1")
Collection<User> findAllActiveUsers();
```

### Sorting
```java
@Query(value = "SELECT u FROM User u")
List<User> findAllUsers(Sort sort);
```
### Pagination
```java
@Query(value = "SELECT u FROM User u ORDER BY id")
Page<User> findAllUsersWithPagination(Pageable pageable);
```
## Query Parameters
### 1. Indexed parameters
```java
// Note: Indexed Parameters start with 1

@Query("SELECT u FROM User u WHERE u.status = ?1")
User findUserByStatus(Integer status);

@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
User findUserByStatusAndName(Integer status, String name);
```
### 2. Named parameters
```java
@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("name") String name));
  
@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByStatusAndNameNamedParams(Integer status, String name);
```

### Collection Parameter
```sql
SELECT u FROM User u WHERE u.name IN :names
SELECT u FROM User u WHERE u.name NOT IN :names
```
```java
@Query(value = "SELECT u FROM User u WHERE u.name IN :names")
List<User> findUserByNameList(Collection<String> names);
```
### Update Queries
We can use the @Query annotation to modify the state of the database by also adding the @Modifying annotation to the repository method.
```java
@Modifying
@Query("update User u set u.status = :status where u.name = :name")
int updateUserSetStatusForName(Integer status, String name);
```
---

# Query Methods
### Defining Query Methods

> Parsing query method names is divided into subject and predicate. The first part (find…By, exists…By) defines the subject of the query, the second part forms the predicate.
```java
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
```
### Property Expressions
> Property Expressions
```java
List<Person> findByAddressZipCode(ZipCode zipCode);
```
### Pagination And Sorting
```java
Page<User> findByLastname(String lastname, Pageable pageable);
Slice<User> findByLastname(String lastname, Pageable pageable);
List<User> findByLastname(String lastname, Sort sort);
List<User> findByLastname(String lastname, Pageable pageable);

Sort sort = Sort.by("firstname").ascending()
  .and(Sort.by("lastname").descending());
```
### Limiting Query Results
```java
User findFirstByOrderByLastnameAsc();
User findTopByOrderByAgeDesc();
Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
Slice<User> findTop3ByLastname(String lastname, Pageable pageable);
List<User> findFirst10ByLastname(String lastname, Sort sort);
List<User> findTop10ByLastname(String lastname, Pageable pageable);
```
### 
```
Optional<User> findOptionalByEmailAddress(EmailAddress emailAddress);
```
### Spring Data Extensions
```java
public interface QuerydslPredicateExecutor<T> {
  Optional<T> findById(Predicate predicate);  
  Iterable<T> findAll(Predicate predicate);   
  long count(Predicate predicate);            
  boolean exists(Predicate predicate);        
  // … more functionality omitted.
}

interface UserRepository extends
    CrudRepository<User, Long>,
    QuerydslPredicateExecutor<User> {

}


Predicate predicate = user.firstname.equalsIgnoreCase("dave")
	.and(user.lastname.startsWithIgnoreCase("mathews"));

userRepository.findAll(predicate);
```
---
# JPQL
### Resources
[Jboss](https://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html)
[Oracle](https://docs.oracle.com/cd/E11035_01/workshop102/ejb/entity/conQueryMethodsandEJBQL.html#standard_EJBQL_operators)
[Bushansirgur](https://bushansirgur.in/jpql-query-using-before-condition/)
[Bushansirgur](https://bushansirgur.in/category/avance-java-j2ee/jpa/)
[Swagger Link](http://localhost:8080/swagger-ui/index.html)

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dept")
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;

}
```
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="emp")
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private LocalDate hiredate;
	private BigDecimal sal;
	@Column(nullable = true)
	private BigDecimal comm;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "dept")
	private Dept dept;
}
```

> HQL is fully object-oriented and understands notions like inheritance, polymorphism and association.

### Operators

### 1. Mathematical operators:
> +, -, *, /

### 2. binary comparison operators:
> =, >=, <=, <>, !=, like

logical operations:
and, or, not

in, not in, between, is null, is not null, is empty, is not empty, member of and not member of

```sql
SELECT OBJECT(o) from ManufacturerBean as o WHERE o.items IS EMPTY
SELECT OBJECT(o) from ItemsBean as o WHERE o.manufacturer IS NULL
SELECT new java.lang.Integer(MAX(e.empno)) FROM Emp e
SELECT e from Emp e WHERE LENGTH(e.ename)=5
SELECT e from Emp e where MONTH(e.hiredate)=5
SELECT e FROM Emp e WHERE e.dept IN (10)
SELECT e FROM Emp e WHERE e.dept NOT IN (10)
SELECT e.sal FROM Emp e WHERE e.sal BETWEEN 1200 AND 2500 
SELECT e.sal FROM Emp e WHERE e.sal NOT BETWEEN 1200 AND 2500 
SELECT e.sal,e.comm FROM Emp e WHERE e.comm IS NULL
SELECT e.sal,e.comm FROM Emp e WHERE e.comm IS NOT NULL
SELECT MONTH(e.hiredate), FROM Emp e
```
second(...), minute(...), hour(...), day(...), month(...), and year(...)

substring(), trim(), lower(), upper(), length(), locate(), abs(), sqrt(), bit_length(), mod()

coalesce() and nullif()


WHERE e.dept.deptno >= 30
Operators: >,<,=,<=,>=,<>

from Cat as cat where cat.mate.name like '%s%'
select cat.name from DomesticCat cat where cat.name like 'fri%'
select cust.name.firstName from Customer as cust

```sql
SELECT e.sal + NULLIF(e.comm, 0) FROM Emp e
SELECT COUNT(*) FROM Emp e
SELECT CoUnT(*) FROM Emp e // Not Case sensitive

SELECT new map( e.dept.deptno as deptno,COUNT(e) as count,MAX(e.sal) as max,MIN(e.sal) as min) FROM Emp e GROUP BY e.dept.deptno
```

### Aggregation Methods
```java
avg(...)
sum(...)
min(...)
max(...)
count(*)
count(...)
count(distinct ...)
count(all...)
```

```sql
SELECT CONCAT(e.ename, ' is earning ',e.sal) FROM Emp e

select distinct cat.name from Cat cat
select count(distinct cat.name), count(cat) from Cat cat

SELECT COUNT(DISTINCT(e.dept)) FROM Emp e
SELECT COUNT(DISTINCT(e.dept)),COUNT(e.dept) FROM Emp e
```
```sql
select foo
from Foo foo, Bar bar
where foo.startDate = bar.date
```
```sql
from Cat cat where cat.mate.name is not null
```
from Foo foo
where foo.bar.baz.customer.address.city is not null

from Cat cat, Cat rival where cat.mate = rival.mate

```sql
SELECT e FROM Emp e
SELECT e FROM Emp e WHERE e.ename like '%S'
SELECT e FROM Emp e WHERE e.comm IS NULL
SELECT e FROM Emp e WHERE e.comm IS NOT NULL
SELECT e.ename,e.dept.deptno FROM Emp e WHERE e.dept.deptno=30
```
---
```sql
SELECT e.ename,e.dept.deptno FROM Emp e WHERE e.comm IS NOT NULL
```
```json
{
    "list": [
        [
            "ALLEN",
            30
        ],
        [
            "WARD",
            30
        ],
        [
            "MARTIN",
            30
        ],
        [
            "TURNER",
            30
        ]
    ]
}
```
---
```sql
SELECT e.ename,e.sal FROM Emp e
```
```json
{
    "list": [
        {
            "empno": 7499,
            "ename": "ALLEN",
            "job": "SALESMAN",
		}
}
```
---
```sql
SELECT e.comm FROM Emp e WHERE e.comm IS NOT NULL
```
```json
{
    "list": [
        300.00,
        500.00,
        1400.00,
        0.00
    ]
}
```
---
```sql
SELECT e.ename,e.comm FROM Emp e WHERE e.comm IS NOT NULL
```
```json
{
    "list": [
        [
            "ALLEN",
            300.00
        ],
        [
            "WARD",
            500.00
        ],
        [
            "MARTIN",
            1400.00
        ],
        [
            "TURNER",
            0.00
        ]
    ]
}
```


```sql
SELECT COUNT(e.ename) FROM Emp e
SELECT COUNT(e.comm) FROM Emp e
SELECT COUNT(e) FROM Emp e - Gives all the records
SELECT e FROM Emp e WHERE e.dept.deptno=20
```
```sql
SELECT e.sal,COUNT(e) FROM Emp e GROUP BY e.sal
```
```json
{
  "list": [
    [
      800,
      1
    ],
    [
      950,
      1
    ]
}
```

---

```sql
SELECT e.dept,COUNT(e) FROM Emp e GROUP BY e.dept
```
```json
{
  "list": [
    [
      {
        "deptno": 10,
        "dname": "ACCOUNTING",
        "loc": "NEW YORK"
      },
      3
    ],
    [
      {
        "deptno": 20,
        "dname": "RESEARCH",
        "loc": "DALLAS"
      },
      5
    ],
    [
      {
        "deptno": 30,
        "dname": "SALES",
        "loc": "CHICAGO"
      },
      6
    ]
  ]
}
```
```sql
SELECT e.dept.deptno, COUNT(e) 	 FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MIN(e.sal) FROM Emp e GROUP BY e.dept
```

---

```sql
SELECT e.dept.dname,  AVG(e.sal) FROM Emp e GROUP BY e.dept
```
```json
{
    "list": [
        [
            10,
            3
        ],
        [
            20,
            5
        ],
        [
            30,
            6
        ]
    ]
}
```

```sql
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MIN(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.dname,  AVG(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.ename, e.dept.dname FROM Emp e WHERE e.dept.dname='ACCOUNTING'
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept HAVING e.dept.deptno > 10
```

---



# Dependencies
```xml
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-ui</artifactId>
	<version>1.6.11</version>
</dependency>

<dependency>
	<groupId>com.github.javafaker</groupId>
	<artifactId>javafaker</artifactId>
	<version>1.0.2</version>
</dependency>
```