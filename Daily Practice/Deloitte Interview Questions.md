Before Java 8 HashMap v/s After Java 8 

The key difference between HashMap in Java 7 and earlier versions compared to Java 8 lies in how it handles collisions:

**Before Java 8:**

* **Collision Handling:** When multiple keys hash to the same bucket (index), they are chained together in a linked list. This is efficient for a small number of collisions, but as the HashMap grows and collisions become more frequent, performance suffers. Traversing a long linked list to find a specific key becomes slow, degrading the average lookup time from ideal O(1) (constant) to O(n) (linear) in the worst case.

**Java 8 onwards:**

* **Improved Collision Handling:** To address this issue, Java 8 introduced a new strategy. Once the number of entries in a bucket exceeds a certain threshold (`TREEIFY_THRESHOLD`), the linked list is replaced with a balanced tree (usually a red-black tree). This allows for more efficient searching (O(log n) time complexity) even with collisions.
* **Benefits:** This change significantly improves the performance of HashMap for larger datasets, especially when dealing with many collisions.

Here's a table summarizing the key differences:

| Feature                 | Before Java 8          | Java 8 onwards         |
|--------------------------|------------------------|-------------------------|
| Collision Handling      | Linked Lists           | Linked Lists (up to a threshold)  |
|                          |                         | Balanced Trees (after threshold) |
| Average Lookup Time     | O(1) (ideal), degrades to O(n) | O(1) (ideal), degrades to O(log n) |

**Additional Notes:**

* Java 8 also removed an alternative String hash function introduced in Java 7 that didn't perform as well.
* The conversion from linked list to tree happens automatically and only when it improves performance. It can switch back to a linked list if the number of entries in the bucket reduces.


HASH FUNCTION
-------------

A hash function is a special algorithm that takes an arbitrary amount of data and condenses it into a fixed-size value, called a hash code or hash value. This hash value acts like a fingerprint for the data, uniquely identifying it. 

















Internal working of hash map
https://ankitwasankar.medium.com/5-tricky-interview-questions-on-hashmap-java-8-a2c7185fd795


String pool in detail



Comparator vs comparable
How can we store one I'd with multiple orders (like one 2 many)


Java 8 stream coding questions, mostly frequency questions. Questions on Microservices architecture, DB performance, Java 8 features, Springboot annotations, Spring core basics, few core java questions, Kafka.


How does spring framework function?

Java Basics,
Use of lambda expression in Java
What is functional interface in Java
polymorphism
Can we use the static variables inside static methods?
Can we use the final keyword with the constructor?
Difference between List and ArrayList?
Which Data Structures(Collection) you have used in your project?


What are the different bean scopes in Spring?
Hibernate Framework,


What was the most challenging technical project I worked on and why



how to create end point in spring boot
 scenerio based questions









Difference between StringBuffer and StringBuilder?
Difference between Post and Put in SpringREST.
Explain MVC design pattern with diagram.
Difference between Application Server and Web Server
how to reverse linked list
How to get the second highest salary from the table?
Difference between Inner Join and Outer join.

Code to sort an array without using any predefined class and methods.






A login page is validating user id and password by getting details from the database. But as the database has billion of rows and it is getting a long time to fetch the data from the database hence throwing errors. What should be the short-term and long-term solutions for this issue?

1. About binary search


Core Java, OOPS, Exception handling, Finding a palindrome etc.

Hod do you do unit testing, how do you do integration testing, have you worked on agile, do you know about devops etc






Questions asked only on database(may be they were looking for SQL developer) and front end like angular/react.

Be prepared, its all on their moods.


basic Java, spring MVC, Hibernate, SQL



describe architecture of your project, which version of java you use, which functionalities of the particular version are used. difference between final, finally and finalize, how is exception handling is used in your project, what is throwable.


What is your Project Architecture , followed by question based on that like , which version of Spring your are currently using?




Difference between Component-Scan and @Component ?






Difference between HashMap and Concurrent HashMap?

What are the real time problems with HashMap ?

Haven't you seen concurrent modification exception ever?

Difference between Rest and Soap?

Did you use MicroServices?


OOPS concepts, day-to-day activities, project, Data base related questions

Caching, multithreading, hashmap working, rest api, string


Hashmap internal implementation , group by SQL command and all joins and there was english fluency test called versant test by Pearson group


Hashmap internal implementation , group by SQL command and all joins and there was english fluency test called versant test by Pearson group


what are the default modifiers in interface

Reverse a string. Print a pyramid pattern from a string. Collections.

1. what is inheritance..!
2. what is interface..!

How to implement stack

Write a method to remove even numbers from list without using any other collection


Print a star pattern

Thread vs Runnable

Immutable class

How concurrent hashmap works?

How to apply security on RESTful web services

If application has more write operations and less read operations. What will you use, Hibernate or JDBC? Why?

Why wait and notify should be called from Synchronized block?

How to implement second level cache in Hibernate?

If your application has multiple databases, how many changes you have to made in Hibernate?

If SOAP is more secure than REST then why many banking application still uses REST?


What is polymorphism ? Give a real life example.


What is the difference between ArrayList and Vector?


What is the difference between HashMap and HashTable?

How multithreading works?


Types of IOC container

1
▼
*Spring IOC Container Type:-
1)Core Container-BeanFactory
2)J2EE Container-ApplicationContext
3)Web Container-WebApplicationContext

▲
0
▼
Two types of IOC Container is there .
1) BeanFactory(old -Lazy loading)
2) ApplicationContext (New- Eager Loading)


Difference between DDL and DML

Why we have 2 representation of String in Java?

Execution sequence of Static Blocks ?

Second highest salary with SQL?

Hash code and Hashmap?

Difference between abstract class and Interface?


what is the business need of Run time polymorphism in your project?

What is dialect in Hibernate?

Hibernate, a popular ORM (Object-Relational Mapper) tool, translates between objects and relational databases. Dialects act as interpreters in this conversation.



Steps for JDBC connection

How to sort objects based on one of it's variables

GenericServlet vs HTTPServlet


Find 2nd and 5th highest salary from table
SELECT DISTINCT salary
FROM (
  SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
  FROM employees
) AS ranked_salaries
WHERE rnk IN (2, 5);





Define Encapsulation and Abstraction. In what scenarios would you use them?

Explain the internal working of hashmap.

Explain the design patterns. Explain Singleton pattern.


Questions about Collection framework.

What are generics


Oops concepts, multithreading, garbage collection in java, hibernate mapping and sql server related questions on joins, cursor and trigger.

Explain all design patterns.


Gave a banking domain business scenario and estimate design costs.

How can you access private functions using reflection

Write a program to check if a String is palindrome or not.


Difference between == and equals method


Write a program to write Fibonacci Series.

 What is polymorphism? What is runtime and compile time polymorphism.
 
 What is concurrent modification exception? How to prevent it.
 
 
How Hashmap works internally?


One question comes to find is the interviewer was asking how do you create JVM ?!!



What's your responsibility in current compnay

what is diff between procedural oriented language and object oriented language

difference between abstraction and encapsulation ?

Is abstraction and abstract class is same ?

difference between abstraction and interface

can muliple inheritan e possible in java using abstract class


write code for jdbc connection in java

how Hashmap internally work

write code to retrieve elements from hashtable

diff between vector and arraylist

what is synchronization

what ibm websphere?is it application server or web server?why you use it?


diff between application server and web server



Abstraction and diff between abstract class and Interface.



They will check your logical understanding by asking some algo e.g. sorting, searching algos and difficulty will depend on your exp. In my case array was given and interviewer asked me to do sorting with any algo.

I was asked about singleton, factory and DAO design pattern as they were on my CV.


Structure of a web application

Inner implementation of Hash map


Use of synchronized keyword and various combination of object along with minor changes in the constructor.




















































































