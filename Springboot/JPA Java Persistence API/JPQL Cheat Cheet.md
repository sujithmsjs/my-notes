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

HQL is fully object-oriented and understands notions like inheritance, polymorphism and association.


Mathematical operators:
+, -, *, /

binary comparison operators:
=, >=, <=, <>, !=, like

logical operations:
and, or, not

in, not in, between, is null, is not null, is empty, is not empty, member of and not member of


SELECT OBJECT(o) from ManufacturerBean as o WHERE o.items IS EMPTY
SELECT OBJECT(o) from ItemsBean as o WHERE o.manufacturer IS NULL
SELECT new java.lang.Integer(MAX(e.empno)) FROM Emp e

SELECT e from Emp e WHERE LENGTH(e.ename)=5
SELECT e from Emp e where MONTH(e.hiredate)=5


SELECT e.sal + IFNULL(e.comm, 0) from Emp e



SELECT e FROM Emp e WHERE e.dept IN (10) // Join not needed
SELECT e FROM Emp e WHERE e.dept NOT IN (10)
SELECT e.sal FROM Emp e WHERE e.sal BETWEEN 1200 AND 2500 
SELECT e.sal FROM Emp e WHERE e.sal NOT BETWEEN 1200 AND 2500 
SELECT e.sal,e.comm FROM Emp e WHERE e.comm IS NULL
SELECT e.sal,e.comm FROM Emp e WHERE e.comm IS NOT NULL

SELECT MONTH(e.hiredate), FROM Emp e
second(...), minute(...), hour(...), day(...), month(...), and year(...)

substring(), trim(), lower(), upper(), length(), locate(), abs(), sqrt(), bit_length(), mod()

coalesce() and nullif()


WHERE e.dept.deptno >= 30
Operators: >,<,=,<=,>=,<>

from Cat as cat where cat.mate.name like '%s%'
select cat.name from DomesticCat cat where cat.name like 'fri%'
select cust.name.firstName from Customer as cust

SELECT e.sal + NULLIF(e.comm, 0) FROM Emp e

SELECT COUNT(*) FROM Emp e
SELECT CoUnT(*) FROM Emp e // Not Case sensitive

SELECT new map( e.dept.deptno as deptno,COUNT(e) as count,MAX(e.sal) as max,MIN(e.sal) as min) FROM Emp e GROUP BY e.dept.deptno


avg(...)
sum(...)
min(...)
max(...)
count(*)
count(...)
count(distinct ...)
count(all...)

SELECT CONCAT(e.ename, ' is earning ',e.sal) FROM Emp e

select distinct cat.name from Cat cat
select count(distinct cat.name), count(cat) from Cat cat

SELECT COUNT(DISTINCT(e.dept)) FROM Emp e
SELECT COUNT(DISTINCT(e.dept)),COUNT(e.dept) FROM Emp e


select foo
from Foo foo, Bar bar
where foo.startDate = bar.date

from Cat cat where cat.mate.name is not null

from Foo foo
where foo.bar.baz.customer.address.city is not null

from Cat cat, Cat rival where cat.mate = rival.mate


SELECT e FROM Emp e
SELECT e FROM Emp e WHERE e.ename like '%S'
SELECT e FROM Emp e WHERE e.comm IS NULL
SELECT e FROM Emp e WHERE e.comm IS NOT NULL

SELECT e.ename,e.dept.deptno FROM Emp e WHERE e.dept.deptno=30
SELECT e.ename,e.dept.deptno FROM Emp e WHERE e.comm IS NOT NULL
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


SELECT e.ename,e.sal FROM Emp e
{
    "list": [
        {
            "empno": 7499,
            "ename": "ALLEN",
            "job": "SALESMAN",
			...
		}
	...
}
		

SELECT e.comm FROM Emp e WHERE e.comm IS NOT NULL
{
    "list": [
        300.00,
        500.00,
        1400.00,
        0.00
    ]
}

SELECT e.ename,e.comm FROM Emp e WHERE e.comm IS NOT NULL
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



SELECT COUNT(e.ename) FROM Emp e - 14
SELECT COUNT(e.comm) FROM Emp e - 4
SELECT COUNT(e) FROM Emp e - Gives all the records

SELECT e FROM Emp e WHERE e.dept.deptno=20




SELECT e.sal,COUNT(e) FROM Emp e GROUP BY e.sal
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
	...
}

SELECT e.dept,COUNT(e) FROM Emp e GROUP BY e.dept
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

SELECT e.dept.deptno, COUNT(e) 	 FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MIN(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.dname,  AVG(e.sal) FROM Emp e GROUP BY e.dept

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

SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.deptno, MIN(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.dept.dname,  AVG(e.sal) FROM Emp e GROUP BY e.dept
SELECT e.ename, e.dept.dname FROM Emp e WHERE e.dept.dname='ACCOUNTING'
SELECT e.dept.deptno, MAX(e.sal) FROM Emp e GROUP BY e.dept HAVING e.dept.deptno > 10


SELECT new com.example.demo.model.MapDTO(e.job, sum(e.sal)) from Emp e GROUP BY e.job
SELECT new com.example.demo.model.MapDTO(e.job, count(*)) from Emp e GROUP BY e.job
SELECT new com.example.demo.model.MapDTO(e.job, count(e.sal)*1000) from Emp e GROUP BY e.job
SELECT new com.example.demo.model.MapDTO(e.job, MONTH(e.hiredate)) from Emp e
SELECT new com.example.demo.model.MapDTO(e.job, concat( MONTH(e.hiredate),e.ename)) from Emp e

{
  "list": [
    {
      "key": "ANALYST",
      "value": 6000
    },
    {
      "key": "CLERK",
      "value": 4150
    },
    {
      "key": "MANAGER",
      "value": 8275
    },
    {
      "key": "PRESIDENT",
      "value": 5000
    },
    {
      "key": "SALESMAN",
      "value": 5600
    }
  ]
}



select distinct cat.name from Cat cat
select count(distinct cat.name), count(cat) from Cat cat
select firstName||' '||initial||' '||upper(lastName) from Person
from Foo foo where foo.bar.baz.customer.address.city is not null

SELECT e from Emp e WHERE e.active=true
SELECT e from Emp e WHERE e.active=FALSE

SELECT DISTINCT e.job from Emp e
{
  "list": [
    "ANALYST",
    "CLERK",
    "MANAGER",
    "PRESIDENT",
    "SALESMAN"
  ]
}

SELECT COUNT(DISTINCT e.job),COUNT(e.job) from Emp e
SELECT e FROM Emp e WHERE e.dept.address.state='TG'



SELECT new java.lang.Integer(MAX(e.empno)) FROM Emp e
SELECT new com.example.demo.model.MapDTO(e.dept.deptno,avg(e.sal)) from Emp e GROUP BY dept
SELECT e FROM 	Emp e 						WHERE dept=20
DELETE 			Emp e 						WHERE dept=20
UPDATE 			Emp e SET e.sal = e.sal+100 WHERE dept=10
UPDATE Emp e SET e.sal = e.sal+100, e.comm=ifnull(e.comm,0)+100 WHERE dept=10    
UPDATE Emp e SET e.ename='SUJITH', e.sal=234423  WHERE e.empno=7369

Modifying method signature can only return void, Integer or int
Updating queries MUST be transactional, mark with @Transactional
Spring Data will drop all non-flushed changes pending in the EntityManager, change with @Modifying(clearAutomatically=false)

UPDATE Emp e SET e.ename='SUJITH', e.sal=234423, e.job='Java SE'  WHERE e.empno=7369

https://www.baeldung.com/spring-data-jpa-modifying-annotation


 



List<User> findByActiveTrue();
List<User> findByActiveFalse();
List<User> findByNameIsNull();
List<User> findByNameIsNotNull();
List<User> findByNameIsNot(String name);
List<User> findByNameIs(String name);
List<User> findByNameEquals(String name);
List<User> findByName(String name);

Long deleteByName(String name);
List<Fruit> deleteByColor(String color);
Long removeByName(String name);
List<Fruit> removeByColor(String color);
List<Passenger> findByFirstNameIgnoreCase(String firstName);

List<Song> findByNameLike(String name);
List<Song> findByNameNotLike(String name);
List<Song> findByNameStartingWith(String startingWith);
List<Song> findByNameEndingWith(String endingWith);
List<Song> findBySingerContaining(String singer);

List<User> findByName(String name);

List<User> findByNameIs(String name);

List<User> findByNameEquals(String name);

List<User> findByNameIsNull();

List<User> findByNameNot(String name);

List<User> findByNameIsNot(String name);

List<User> findByNameStartingWith(String name);

List<User> findByNameEndingWith(String name);

List<User> findByNameContaining(String name);

List<User> findByNameLike(String name);

List<User> findByAgeLessThan(Integer age);

List<User> findByAgeLessThanEqual(Integer age);

List<User> findByAgeGreaterThan(Integer age);

List<User> findByAgeGreaterThanEqual(Integer age);

List<User> findByAgeBetween(Integer startAge, Integer endAge);

List<User> findByBirthDateAfter(ZonedDateTime birthDate);

List<User> findByBirthDateBefore(ZonedDateTime birthDate);

List<User> findByActiveTrue();

List<User> findByActiveFalse();

List<User> findByAgeIn(Collection<Integer> ages);

List<User> findByNameOrBirthDate(String name, ZonedDateTime birthDate);

List<User> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);

List<User> findByNameOrderByName(String name);

List<User> findByNameOrderByNameDesc(String name);

List<User> findByNameIsNotNull();

List<User> findByNameOrderByNameAsc(String name);

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

List<Person> findByAddress_ZipCode(ZipCode zipCode);

Page<User> findByLastname(String lastname, Pageable pageable);

Slice<User> findByLastname(String lastname, Pageable pageable);

List<User> findByLastname(String lastname, Sort sort);

List<User> findByLastname(String lastname, Pageable pageable);

---------------------------------------------------------------------------------
# Limiting Query Results
---------------------------------------------------------------------------------
User findFirstByOrderByLastnameAsc();

User findTopByOrderByAgeDesc();

Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);

Slice<User> findTop3ByLastname(String lastname, Pageable pageable);

List<User> findFirst10ByLastname(String lastname, Sort sort);

List<User> findTop10ByLastname(String lastname, Pageable pageable);

User findFirstByOrderByName();

User findTopByOrderByAgeDesc();

List<User> findFirst5ByEmail(String email);

List<User> findDistinctTop3ByAgeLessThan(int age);

---------------------------------------------------------------------------------
# Limiting Query Results
---------------------------------------------------------------------------------

Streamable<Person> findByFirstnameContaining(String firstname);
Streamable<Person> findByLastnameContaining(String lastname);
Products findAllByDescriptionContaining(String text);

---------------------------------------------------------------------------------
# Null Values Handling
---------------------------------------------------------------------------------

User getByEmailAddress(EmailAddress emailAddress);                    

@Nullable
User findByEmailAddress(@Nullable EmailAddress emailAdress);          

Optional<User> findOptionalByEmailAddress(EmailAddress emailAddress);

---------------------------------------------------------------------------------
# Limiting Query Results
---------------------------------------------------------------------------------
# find users by the last name
List<User> findByLastName(String lastName);

# find distinct users by email
List<User> findDistinctByEmail(String email);

# count users by profession
int countByProfession(String profession);

List<User> findByActiveAndBirthDateOrNameAndAge(boolean active,Date dob, String name, int age);


-------------------------------------------------


List<User> findByNameIs(String name);
// OR
List<User> findByNameEquals(String name);


----------------------------------------------------
List<User> findByNameIsNot(String name);
// OR
List<User> findByNameNot(String name);
----------------------------------------------------

List<User> findByEmailIsNull();
List<User> findByEmailIsNotNull();

----------------------------------------------------
List<User> findByActiveTrue();
List<User> findByActiveFalse();
----------------------------------------------------
List<User> findByNameStartingWith(String prefix);
// OR
List<User> findByNameIsStartingWith(String prefix);
// OR
List<User> findByNameStartsWith(String prefix);

List<User> findByNameEndingWith(String suffix);


List<User> findByNameContaining(String infix);
List<User> findByEmailLike(String pattern);

----------------------------------------------------

List<User> findByAgeLessThan(int age);
List<User> findByAgeLessThanEqual(int age);

List<User> findByAgeGreaterThan(int age);
List<User> findByAgeGreaterThanEqual(int age);

List<User> findByAgeBetween(int start, int end);

List<User> findByBirthDateBefore(Date before);
List<User> findByBirthDateAfter(Date after);

List<User> findDistinctByEmail(String email);
List<User> findDistinctPeopleByNameOrEmail(String name, String email);

List<User> findByNameIgnoreCase(String name);
----------------------------------------------------
To enable a case-insensitive search for all suitable properties, you should use the AllIgnoreCase keyword:
List<User> findByNameOrEmailAllIgnoreCase(String name, String email);

List<User> findByNameContainingOrderByName(String name);
// OR
List<User> findByNameContainingOrderByNameAsc(String name);

List<User> findByNameContainingOrderByNameDesc(String name);

List<User> findByNameContaining(String name, Sort sort);



----------------------------------------------------
# Paginatoin

Page<User> findByActive(boolean active, Pageable pageable);


----------------------------------------------------

// delete all users by name
void deleteByName(String name);

// delete all active or inactive users
void deleteAllByActive(boolean active);


----------------------------------------------------

boolean existsByTitleIgnoreCase(String title);
boolean existsByNameIgnoreCase(String name);

----------------------------------------------------
----------------------------------------------------

















