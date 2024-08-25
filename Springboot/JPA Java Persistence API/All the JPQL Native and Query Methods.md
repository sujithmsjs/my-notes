
# Native Queries JPA Cheat Sheet






```java
@Query("SELECT e.ename, d.dname FROM Employee e JOIN e.dept d")
	List<?> findEmployeesWithDept();
	
	@Query("SELECT e.ename FROM Employee e where e.id = :id")
	Optional<String> findEnameById(int id);

	@Query("SELECT e.ename FROM Employee e where e.mgr = :mgr")
	
	@Query("SELECT e.job, max(sal) from Employee e GROUP BY e.job")
	List<?> groupByJobMax();
	
	@Query("SELECT e.job, min(sal) from Employee e GROUP BY e.job")
	List<?> groupByJobMin();

	@Query("SELECT e.job, count(sal) from Employee e GROUP BY e.job")
	List<?> groupByJobCount();

	@Query("SELECT e.job, avg(sal) from Employee e GROUP BY e.job")
	List<?> groupByJobAvg();
	
	@Query("SELECT e.job, sum(sal) from Employee e GROUP BY e.job")
	List<?> groupByJobSum();
```









```java
// RETRIVE METHODS
	
	boolean existsByEname(String name);
	boolean existsByEnameContainsIgnoreCase(String name);
	boolean existsByEnameStartsWithIgnoreCase(String name);

	
	int countByEnameContainsIgnoreCase(String name);
	
	@Query("select new java.lang.String(e.ename) from Employee e")
	public List<String> findAllEmployeeNames();
	
	List<Employee> findByEnameContainsIgnoreCase(String name);

	List<Employee> findByEnameStartingWith(String name);

	List<Employee> findByEnameStartingWithIgnoreCase(String name);

	List<Employee> findByEnameIgnoreCase(String name);

	
	
	// DELETE METHODS
	
	@Transactional
	int deleteByEname(String name);

	@Transactional
	int deleteById(int id);

	@Transactional
	long deleteByEnameIgnoreCase(String name);

	@Transactional
	List<Employee> removeByEnameIgnoreCase(String lastname);
	
	// UPDATE METHODS
	
	@Modifying
	@Transactional
	@Query("update Employee e set e.sal = :sal where e.empno = :id")
	int updateSalaryById(int id, BigDecimal sal);

	
	@Modifying
	@Transactional
	@Query("update Employee e set e.sal = :sal where e.ename like :name")
	int updateSalaryByNameLike(String name, BigDecimal sal);
```




```java
Entity 		    findBy<Property>(Property name);
List<Entity> 	findBy<Property>(Property name);
boolean 	    existsBy<Property>Property value);
Optional<Entity> getBy<Property>(Property name);
Entity		    getBy<Property>(Property name);
List<Entity>    findByActive<True/False>();
List<Entity>    findBy<Property><After/Before>(ZonedDateTime birthDate);
List<Entity>    findBy<Property>Equals(String name);
List<Entity>    findBy<Property>< Is / IsNot > <Null / Ignore> (String name);
List<Entity>    findAllByOrderBy<Property><Desc / Asc / Ignore >();
List<Entity>    findBy<Property><Starting/Ending>With(String prefix);
List<Entity>    findBy<Property>Containing(String infix);
List<Entity>    findBy<Property><Like / NotLike>(String likePattern);
List<Entity>    findBy<Property><Less/Greater>Than<Equal/Ignore>(BigDecimal sal);
List<Entity>    findBy<Property>Between(BigDecimal bigDecimal, BigDecimal bigDecimal2);
List<Entity>    findBy<Property>In(List<Integer> collect);
Optional<Student> findFirstBy<Property>(PropertyType type);
List<Student>   findFirst<Number>ByOrderBy<Property><Asc/Desc/Ignore>();
Student         findFirstByOrderByName();

Ex:-
List<Entity> findBySalLessThanOrderBySalAsc(BigDecimal bigDecimal);
List<Entity> findBySalLessThanAndCommNotNull(BigDecimal bigDecimal);
List<Entity> findBySalLessThanAndCommNotNullOrderByComm(BigDecimal bigDecimal);
List<Entity> findByNameOrBirthDate(String name, ZonedDateTime birthDate);
List<Entity> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);

```










----
## Model class
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="emp")
public class Employee {
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
	private Department dept;

}
```

## Repository
```java
package com.suji.empmgnt.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suji.empmgnt.model.Employee;

@Repository
public interface EmployeeRepositoryNativeQuries extends JpaRepository<Employee, Integer> {
    /////////////////// /////////
	///// RETRIEVE QUERIES //////
	/////////////////// /////////
	
	// Fine Employees whose salary is 800
	@Query(value = "select * FROM EMP e where e.sal = 800", nativeQuery = true)
	public List<Employee> findWhosSalaryIs800();

	// Show the Max Salary
	@Query(value = "SELECT max(sal) FROM EMP", nativeQuery = true)
	public BigDecimal findMaxSalary();

	// Find Max Salaried Employee
	@Query(value ="SELECT * FROM emp WHERE sal IN(SELECT MAX(sal) FROM emp)", nativeQuery = true)
	public List<Employee> findMaxSalEmployee();
	
	// Select Employees matching with pattern
	@Query(value = "SELECT * FROM EMP WHERE ENAME LIKE %:pattern%", nativeQuery = true)
	public List<Employee> searchBy(String pattern);
	
	//////////////////////////////////////////////////////////////////////////////
	// NOTE: @Modifying queries can only use void or int/Integer as return type!
	// NOTE: Whenever you use this @Modiying methods, that method should be annotated with @Transactional
	// NOTE: Child table(EMP table) should not have "CascadeType.ALL" or "CascadeType.ALL"
	//////////////////////////////////////////////////////////////////////////////
	
	/////////////////// ////////
	///// DELETE QUERIES ///////
	/////////////////// ////////
	
	// Delete Employees whose name is like
	@Modifying
	@Query(value = "DELETE FROM EMP WHERE ENAME LIKE :name", nativeQuery = true)
	public long deleteByName(String name);
	
	// Delete Employees whose salary is below the given number
	@Modifying
	@Query(value = "DELETE FROM EMP WHERE SAL <= :salary", nativeQuery = true)
	public int deleteBelowSalaryEmployees(double salary);
	
	// Delete All Employees
	@Modifying
	@Query(value = "DELETE FROM EMP", nativeQuery = true)
	public long deleteAllEmployees();
	
	// Delete Employees whose name starts with the given pattern
	@Modifying
	@Query(value = "DELETE FROM EMP WHERE ENAME LIKE %:pattern", nativeQuery = true)
	public int deleteEmploeesStartsWith(String pattern);
	
	////////////////////////////
	///// UPDATE QUERIES //////
	///////////////////////////
	
	// Set :newSalary to those, whose salary is below :belowSalary.
	@Modifying
	@Query(value = "UPDATE EMP SET SAL=:newSalary WHERE SAL<=:belowSalary", nativeQuery = true)
	public int updateEmpSalary(double newSalary, double belowSalary);
	

	// Salary increment by Id
	@Modifying 
	@Query(value = "UPDATE EMP SET SAL = SAL + :increment WHERE EMPNO=:id", nativeQuery = true)
	public int updateSalaryById(int id, double increment);

	// Salary increment by Id
	@Modifying
	@Query(value = "UPDATE EMP SET SAL = SAL + :increment WHERE EMPNO=:id", nativeQuery = true)
	public List<Employee> updateSalaryById2(int id, double increment);
}

```

---
---

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
> `+, -, *, /`

### 2. binary comparison operators:
> `=, >=, <=, <>, !=, like`

logical operations:
`and, or, not`

`in, not in, between, is null, is not null, is empty, is not empty, member of and not member of`

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

- second(...)
- minute(...)
- hour(...)
- day(...)
- month(...)
- year(...)

`substring(), trim(), lower(), upper(), length(), locate(), abs(), sqrt(), bit_length(), mod()`

`coalesce() and nullif()`


WHERE `e.dept.deptno >= 30`
Operators: `>,<,=,<=,>=,<>`

```sql
SELECT from Cat as cat where cat.mate.name like '%s%'
SELECT cat.name from DomesticCat cat where cat.name like 'fri%'
SELECT cust.name.firstName from Customer as cust

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

from Foo foo
where foo.bar.baz.customer.address.city is not null

from Cat cat, Cat rival where cat.mate = rival.mate
```
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


Retrive with JPQL
------------------------------------------

```java

@Query("select new java.lang.String(e.ename) from Employee e")
public List<String> findAllEmployeeNames();

@Query(value = "SELECT * FROM EMP WHERE ENAME LIKE %:pattern%", nativeQuery = true)
List<Employee> searchBy(String pattern);

@Query("SELECT e.ename, d.dname FROM Employee e JOIN e.dept d")
List<?> findEmployeesWithDept();

@Query("SELECT e.ename FROM Employee e where e.id = :id")
Optional<String> findEnameById(int id);

@Query("SELECT e.ename FROM Employee e where e.mgr = :mgr")
List<String> findFirstByMgr(int mgr);

@Query("SELECT e.job, max(sal) from Employee e GROUP BY e.job")
List<?> groupByJobMax();

@Query("SELECT e.job, min(sal) from Employee e GROUP BY e.job")
List<?> groupByJobMin();

@Query("SELECT e.job, count(sal) from Employee e GROUP BY e.job")
List<?> groupByJobCount();

@Query("SELECT e.job, avg(sal) from Employee e GROUP BY e.job")
List<?> groupByJobAvg();

@Query("SELECT e.job, sum(sal) from Employee e GROUP BY e.job")
List<?> groupByJobSum();
	
@Query("SELECT u FROM User u WHERE u.status = ?1")
User findUserByStatus(Integer status);

@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
User findUserByStatusAndName(Integer status, String name);

@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByStatusAndNameNamedParams(@Param("status") Integer status, @Param("name") String name));
  
@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
User findUserByStatusAndNameNamedParams(Integer status, String name);

@Query(value = "SELECT u FROM User u WHERE u.name IN :names")
List<User> findUserByNameList(Collection<String> names);
```

Delete with JPQL
------------------------------------------

```java
@Modifying
@Query(value = "DELETE FROM EMP WHERE ENAME LIKE :name", nativeQuery = true)
int deleteByName(String name);
```


Modify with JPQL
------------------------------------------
```java
@Modifying
@Transactional
@Query("update Employee e set e.sal = :sal where e.empno = :id")
int updateSalaryById(int id, BigDecimal sal);


@Modifying
@Transactional
@Query("update Employee e set e.sal = :sal where e.ename like :name")
int updateSalaryByNameLike(String name, BigDecimal sal);
```


Retrive with Query Method
------------------------------------------
```java
List<Employee> findAllByOrderByEname();
List<Employee> findAllByOrderByEnameDesc();
List<Employee> findAllByOrderBySalDesc();
List<Employee> findAllByOrderBySalAsc();
List<Employee> findAllByOrderBySal();

List<Employee> findByEname(String name);
List<Employee> findByEnameIs(String name);
List<Employee> findByEnameEquals(String name);
List<Employee> findByEnameIsNot(String name);

List<Employee> findByCommIsNull();
List<Employee> findByCommIsNotNull();

List<Employee> findByEnameStartingWith(String prefix);
List<Employee> findByEnameStartingWithAndEnameEndingWith(String prefix,String suffix);
List<Employee> findByEnameContaining(String infix);
List<Employee> findByEnameEndingWith(String suffix);

List<Employee> findByEnameLike(String likePattern);
List<Employee> findByEnameNotLike(String likePattern);

List<Employee> findBySalLessThan(BigDecimal sal);
List<Employee> findBySalLessThanEqual(BigDecimal sal);
List<Employee> findBySalGreaterThanEqual(BigDecimal sal);
List<Employee> findBySalGreaterThan(BigDecimal bigDecimal);
List<Employee> findBySalLessThanOrderBySalAsc(BigDecimal bigDecimal);
List<Employee> findBySalLessThanAndCommNotNull(BigDecimal bigDecimal);
List<Employee> findBySalLessThanAndCommNotNullOrderByComm(BigDecimal bigDecimal);

List<Employee> findByDeptno(int i);
List<Employee> findBySalBetween(BigDecimal bigDecimal, BigDecimal bigDecimal2);
List<Employee> findByDeptnoIn(List<Integer> collect);

Optional<Employee> getByEname(String name);



Employee getByUsername(String name);

List<User> findByActiveTrue();
List<User> findByActiveFalse();

List<User> findByBirthDateAfter(ZonedDateTime birthDate);
List<User> findByBirthDateBefore(ZonedDateTime birthDate);

List<User> findByNameOrBirthDate(String name, ZonedDateTime birthDate);
List<User> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);

Student 	findByName(String string);
List<Student> 		findByDobAfter(LocalDate of);
List<Student> 		findByDobBefore(LocalDate of);
List<Student> 		findByActiveTrue();
List<Student> 		findByActiveFalse();
List<Student> 		findByOrderByName();
List<Student> 		findByOrderByCgpaDesc();
List<Student> 		findByOrderByDob();
Student 			findFirstByOrderByName();
Optional<Student>	findFirstByOrderByCgpa();
Optional<Student>	findTopByOrderByCgpaDesc();
List<Student> 		findTop3ByOrderByCgpaDesc();
Optional<Student>	findFirstByName(String string);
Optional<Student>	findFirstByGender(Gender gender);
Optional<Student>	findFirstByGenderOrderByCgpaDesc(Gender gender);
Optional<Student>	findFirstByGenderOrderByCgpa(Gender gender);
List<Student> 		findFirst3ByOrderByCgpaDesc();
List<Student> 		findAll(Sort sort);

List<Employee> 	findByEnameContainsIgnoreCase(String name);
List<Employee> 	findByEnameStartingWith(String name);
List<Employee> 	findByEnameStartingWithIgnoreCase(String name);
List<Employee> 	findByEnameIgnoreCase(String name);
List<Person>    findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
List<Person>    findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
List<Person>    findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
List<Person>    findByLastnameIgnoreCase(String lastname);
List<Person>    findByLastnameOrderByFirstnameAsc(String lastname);
List<Person>    findByLastnameOrderByFirstnameDesc(String lastname);
List<Person>    findByAddressZipCode(ZipCode zipCode);
Page<User>      findByLastname(String lastname, Pageable pageable);
Slice<User>     findByLastname(String lastname, Pageable pageable);
List<User>      findByLastname(String lastname, Sort sort);
List<User>      findByLastname(String lastname, Pageable pageable);
User            findFirstByOrderByLastnameAsc();
User            findTopByOrderByAgeDesc();
Page<User>      queryFirst10ByLastname(String lastname, Pageable pageable);
Slice<User>     findTop3ByLastname(String lastname, Pageable pageable);
List<User>      findFirst10ByLastname(String lastname, Sort sort);
List<User>      findTop10ByLastname(String lastname, Pageable pageable);
Optional<T>     findById(Predicate predicate);  
Iterable<T>     findAll(Predicate predicate);   
long            count(Predicate predicate);            
```


Delete with Query Method
------------------------------------------

```java
@Transactional
int deleteByEname(String name);

@Transactional
int deleteById(int id);

@Transactional
long deleteByEnameIgnoreCase(String name);

@Transactional
List<Employee> removeByEnameIgnoreCase(String lastname);
```

Existence Texting with Query Method
------------------------------------------

```java
boolean exists(Predicate predicate);  
boolean existsByEname(String value);
boolean existsByEname(String name);
boolean existsByEnameContainsIgnoreCase(String name);
boolean existsByEnameStartsWithIgnoreCase(String name);
int     countByEnameContainsIgnoreCase(String name);
```



Retrive with Native Query
------------------------------------------
```java



@Query(value = "SELECT * FROM odeskb2b.odesk_users where org_id = ?1", nativeQuery = true)
public List<Integer> findAllUserIds(Pageable pageable, Integer orgId);

@Query(value = "select * FROM EMP e where e.sal = 800", nativeQuery = true)
public List<Employee> findWhosSalaryIs800();

@Query(value = "SELECT max(sal) FROM EMP", nativeQuery = true)
public BigDecimal findMaxSalary();

@Query(value ="SELECT * FROM emp WHERE sal IN(SELECT MAX(sal) FROM emp)", nativeQuery = true)
public List<Employee> findMaxSalEmployee();

@Query(value = "SELECT * FROM EMP WHERE ENAME LIKE %:pattern%", nativeQuery = true)
public List<Employee> searchBy(String pattern);
```

Pagination with Native Query
------------------------------------------
```java
@Query(
  value = "SELECT * FROM Users ORDER BY id", 
  countQuery = "SELECT count(*) FROM Users", 
  nativeQuery = true)
Page<User> findAllUsersWithPagination(Pageable pageable);
```

Delete with Native Query
------------------------------------------
```java
@Modifying
@Query(value = "DELETE FROM EMP WHERE ENAME LIKE :name", nativeQuery = true)
public long deleteByName(String name);

@Modifying
@Query(value = "DELETE FROM EMP WHERE SAL <= :salary", nativeQuery = true)
public int deleteBelowSalaryEmployees(double salary);

@Modifying
@Query(value = "DELETE FROM EMP", nativeQuery = true)
public long deleteAllEmployees();

@Modifying
@Query(value = "DELETE FROM EMP WHERE ENAME LIKE %:pattern", nativeQuery = true)
public int deleteEmploeesStartsWith(String pattern);
```
Modify with Native Query
------------------------------------------
```java
@Modifying
@Query(value = "UPDATE EMP SET SAL=:newSalary WHERE SAL<=:belowSalary", nativeQuery = true)
public int updateEmpSalary(double newSalary, double belowSalary);

@Modifying 
@Query(value = "UPDATE EMP SET SAL = SAL + :increment WHERE EMPNO=:id", nativeQuery = true)
public int updateSalaryById(int id, double increment);

@Modifying
@Query(value = "UPDATE EMP SET SAL = SAL + :increment WHERE EMPNO=:id", nativeQuery = true)
public List<Employee> updateSalaryById2(int id, double increment);

@Modifying
@Query("update User u set u.status = :status where u.name = :name")
int updateUserSetStatusForName(Integer status, String name);







```


--------------
JPQL QUERIES
--------------
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
SELECT CONCAT(e.ename, ' is earning ',e.sal) FROM Emp e
select distinct cat.name from Cat cat
select count(distinct cat.name), count(cat) from Cat cat
SELECT COUNT(DISTINCT(e.dept)) FROM Emp e
SELECT COUNT(DISTINCT(e.dept)),COUNT(e.dept) FROM Emp e
SELECT e FROM Emp e
SELECT e FROM Emp e WHERE e.ename like '%S'
SELECT e FROM Emp e WHERE e.comm IS NULL
SELECT e FROM Emp e WHERE e.comm IS NOT NULL
SELECT e.ename,e.dept.deptno FROM Emp e WHERE e.dept.deptno=30
SELECT e.ename,e.dept.deptno FROM Emp e WHERE e.comm IS NOT NULL
SELECT COUNT(e.ename) FROM Emp e
SELECT COUNT(e.comm) FROM Emp e
SELECT COUNT(e) FROM Emp e - Gives all the records
SELECT e FROM Emp e WHERE e.dept.deptno=20
SELECT e.sal,COUNT(e) FROM Emp e GROUP BY e.sal
SELECT e.dept,COUNT(e) FROM Emp e GROUP BY e.dept

SELECT e.dept.deptno, COUNT(e) 	 FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MIN(e.sal) FROM Emp e GROUP BY e.dept

SELECT e.dept.dname,  AVG(e.sal) FROM Emp e GROUP BY e.dept

SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MIN(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.dname,  AVG(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.ename, e.dept.dname FROM Emp e WHERE e.dept.dname='ACCOUNTING'
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept HAVING e.dept.deptno > 10

SELECT b, p FROM Book b, Publisher p WHERE b.fk_publisher = p.id
SELECT a, b FROM Author a LEFT JOIN a.books b
SELECT a, p FROM Author a JOIN a.publications p ON p.publishingDate > ?1
SELECT b FROM Book b WHERE b.publisher.name LIKE ‘%es%
SELECT p FROM Publication p
SELECT b FROM BlogPost b
SELECT a, p FROM Author a JOIN treat (a.publications AS Book) p

Select a from Author a where size(a.books) > 1;
SELECT a.firstName, a.lastName FROM Author a
```


-------------------------
Joining multiple entities
-------------------------

1. Inner joins
2. Left Outer Joins
3. Additional Join Conditions
4. Path expressions or implicit joins




1. Inner joins:
1.1 Related Entities
1.2 Unrelated Entities

1.1 Related Entities
Eg:-

```java
Author{
	List<Book> books;
}

Book{
}
```

```java
SELECT a, b FROM Author a JOIN a.books b

@Query("SELECT e.ename, d.dname FROM Employee e JOIN e.dept d")
List<?> findEmployeesWithDept();
```


1.2 Unrelated Entities

SELECT b, p FROM Book b, Publisher p WHERE b.fk_publisher = p.id




2. Left Outer Joins:

SELECT a, b FROM Author a LEFT JOIN a.books b


3. Additional Join Conditions:

SELECT a, p FROM Author a JOIN a.publications p ON p.publishingDate > ?1

4. Path expressions or implicit joins:

SELECT b FROM Book b WHERE b.publisher.name LIKE ‘%es%

Polymorphism and Downcasting
----------------------------

1. Polymorphism: When you choose an inheritance strategy that supports polymorphic queries, your query selects all instances of the specified class and its subclasses.

```java
Publication{}
Book extends Publication{}
BlogPost extends Publication{}
```
Eg:-
```sql
SELECT p FROM Publication p
SELECT b FROM BlogPost b
```
2. Downcasting

```sql
SELECT a, p FROM Author a JOIN treat (a.publications AS Book) p
```

------------------------
WHERE CLAUSE
-----------------------
Operators for single-valued expressions:
------------------------------------------
Equal:          `author.id = 10`
Not equal:      `author.id <> 10`
Greater than:   `author.id > 10`
Greater or equal then: `author.id => 10`
Smaller than: `author.id < 10`
Smaller or equal then: `author.id <= 10`
Between:        `author.id BETWEEN 5 and 10`
Like:           `author.firstName LIKE ‘%and%’`
Is null:        `author.firstName IS NULL`
Is not null:    `author.firstName IS NULL`
In:             `author.firstName IN (‘John’, ‘Jane’)`

Operators for collection expressions
-------------------------------------
Size: `size(author.books) > 2`
Member of: `:myBook member of author.books`
Is empty: `author.books IS EMPTY`

Eg:
```sql
SELECT a FROM Author a
WHERE 	a.firstName like ‘%and%’
	and a.id >= 20
	and size(author.books) >= 5
```

------------------------------
Projection – The SELECT clause
------------------------------
1. Entities
2. Scalar values
3. Constructor references
4. Distinct Query Results

1. Entities:
    ```sql
	Select a from Author a;
	Select a from Author a where size(a.books) > 1;
    ```
2. Scalar values:
    ```sql
	SELECT a.firstName, a.lastName FROM Author a
    ```
3. Constructor references
Need to provide fully qualified class name.
		
SELECT new org.thoughts.on.java.model.AuthorValue(a.id, a.firstName, a.lastName) FROM Author a

4. Distinct Query Results
    ```sql    
	SELECT DISTINCT a.lastName FROM Author a
    ```

PREDEFINED FUNCTIONS
---------------------

- upper(str)
- lower(str)
- current_date()
- current_time()
- current_timestamp()
- substring(str, offset, length)
- trim(str)
- length(str)
- locate(String search, String s, int offset)
- abs(Numeric n)
- sqrt(Numeric n)
- mod(Numeric dividend, Numeric divisor): returns the remainder of a division
- treat(x as Type): downcasts x to the given Type
- size(Collection c)
- abs(Numeric n)
- index(orderedCollection): returns the index of the given value in an ordered Collection



Grouping – The GROUP BY and HAVING clause
-------------------------------------------

- count(var)
- sum(var)
- max(var)
- min(var)
- avg(var)

    ```sql
	SELECT a.lastName, COUNT(a) FROM Author a GROUP BY a.lastName
	```
Ex:
```java
@Query("SELECT e.job, count(job) from Employee e GROUP BY e.job")
List<?> groupByLastName();

List<?> list = repo.groupByLastName();
list.forEach(obj -> {
	Object[] arr = (Object[]) obj;
	System.out.println(Arrays.toString(arr));
});
```

-------------------------------
Ordering – The ORDER BY clause
-------------------------------
```sql
SELECT a FROM Author a ORDER BY a.lastName ASC, a.firstName DESC

SELECT a FROM Author a
	WHERE (SELECT count(b) FROM Book b WHERE a MEMBER OF b.authors ) > 1
```









