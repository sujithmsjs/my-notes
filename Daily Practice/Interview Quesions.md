Interview Quesions

HTTP Only Cookies
XSS	: 	cross-site scripting
CSP	: 	Content security policies
CORS: 	Cross-Origin Resource Sharing
CSRF: 	cross-site request forgery 
MFA :	multi-factor authentication
SPA : 	Single-page applications


	int[] -> IntStream
	int[] -> Integer[]
	int[] -> List<Integer>
	int[] -> Stream<Integer>

	IntStream -> int[]
	IntStream -> Integer[]
	IntStream -> List<Integer>
	IntStream -> Stream<Integer>

	Integer[] -> int[]
	Integer[] -> IntStream
	Integer[] -> List<Integer>
	Integer[] -> Stream<Integer>

	Stream<Integer> -> int[]
	Stream<Integer> -> IntStream
	Stream<Integer> -> List<Integer>
	Stream<Integer> -> Integer[]
	
	
public static <T> List<T> asList(T... a)

<<<<<<< Updated upstream
public static <T> Stream<T> stream(T[] array)
public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive)

public static <T> Spliterator<T> spliterator(T[] array)
public static <T> Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive)


xxx -> Int/Long/Double
public static xxxStream stream(xxx[] array)
public static xxxStream stream(xxx[] array,int startInclusive,int endExclusive)
public static void sort(xxx[] a)
public static Spliterator.Ofxxx spliterator(xxx[] array)
public static boolean equals(xxx[] a,xxx[] a2)

- Returns true if the two specified arrays of ints are equal to one another.
- Two arrays are considered equal if both arrays contain the same number of elements, and all corresponding pairs of elements in the two arrays are equal. In other words, two arrays are equal if they contain the same elements in the same order. Also, two array references are considered equal if both are null.
=======

Why @FunctionalInterface annotation?


The @FunctionalInterface annotation provides a clear indication to developers that the interface is intended to be used as a functional interface.
The @FunctionalInterface annotation tells the compiler to check whether the interface qualifies as a functional interface.
>>>>>>> Stashed changes




<<<<<<< Updated upstream
public static void sort(Object[] a)
Sorts the specified array of objects into ascending order, according to the natural ordering of its elements. All elements in the array must implement the Comparable interface. Furthermore, all elements in the array must be mutually comparable (that is, e1.compareTo(e2) must not throw a ClassCastException for any elements e1 and e2 in the array).


Int/Long/Double Stream
----------------------
static IntStream	of(int... values)
static IntStream	range(int startInclusive, int endExclusive)
static IntStream	concat(IntStream a, IntStream b)


Stream<Integer>	boxed()

OptionalInt		max()
OptionalInt		min()
OptionalDouble 	average()
long			count()
int				sum()

int[]			toArray()
int				reduce(int identity, IntBinaryOperator op)

void			forEachOrdered(IntConsumer action)
IntStream		map(IntUnaryOperator mapper)
DoubleStream	mapToDouble(IntToDoubleFunction mapper)
LongStream		mapToLong(IntToLongFunction mapper)
<U> Stream<U>	mapToObj(IntFunction<? extends U> mapper)


----

@Configuration
@ConfigurationProperties(prefix = "mail")

isolate configuration properties into separate POJOs


@ConfigurationProperties works best with hierarchical properties that all have the same prefix; therefore, we add a prefix of mail.

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class EnableConfigurationDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnableConfigurationDemoApplication.class, args);
    }
}

@Configuration
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {
    
    private String hostName;
    private int port;
    private String from;

    // standard getters and setters
}


-> @Configuration should be there to let Spring to create a bean. If you don't want to use @Configuration on POJO class, @EnableConfigurationProperties has to be placed on the main Stringboot application class to bind the properties into the POJOs.
-> Or else Spring boot 2.2 introduced @ConfigurationPropertiesScan to use along with @ConfigurationProperties.

@ConfigurationProperties(prefix = "mail.credentials")
--------
=======
---


Interface-based DTO projections
- Alias of each column
- Getter method
- At runtime, Spring Data JPA then generates a class that implements that interface.
- Snake case
- If  emergency_contact as EmergencyContact, The interface method should be  set+EmergencyContact



Class-based DTO projections


The Automatic Mapping Doesn't Work
- ConverterNotFoundException 
You have 2 options to avoid this exception:
- @NamedNativeQuery with an @SqlResultSetMapping
- A fragment Interface





@NamedNativeQuery with an @SqlResultSetMapping
Conclusion








---------------

PROJECT TO THE DERIVED QUERIES

interface NamesOnly {

  String getFirstname();
  String getLastname();
}

interface PersonRepository extends Repository<Person, UUID> {

  Collection<NamesOnly> findByLastname(String lastname);
}



A projection interface to retrieve a subset of attributes
interface PersonSummary {

  String getFirstname();
  String getLastname();
  AddressSummary getAddress();

  interface AddressSummary {
    String getCity();
  }
}

Closed Projections
A projection interface whose accessor methods all match properties of the target aggregate is considered to be a closed projection. 


Open Projections
Accessor methods in projection interfaces can also be used to compute new values by using the @Value annotation, as shown in the following example:


An Open Projection
interface NamesOnly {
  @Value("#{target.firstname + ' ' + target.lastname}")
  String getFullName();
}

Nullable Wrappers
-----------------
Nullable Wrappers
Getters in projection interfaces can make use of nullable wrappers for improved null-safety. 






JPA Query Methods
-----------------
https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html










Query by Example
----------------



I want to design a Microservices application.
Name is EmployeeManager
It contains 4 Services
1. Employee Services
2. Company Services
3. Bank Services
4. Department Service

I want you to explain how to set Spring Gateway, and Eureka Service, Eureka Clients, Config Server and Service Breakers.
You need to explain how many Services I need to create. How many component I need to use.
Where should I implement Security releated code.
You should also expain me best practices.




1. How you create SingleTon class?
2. How you an object Immutable?
3. How to Service to Service communication will be done?
4. Explain about Exception?
5. Explain Volatile keyword?
6. What is marker interface?
7. What is Serializaiton and Deserialization?
8. How to make a field not perticipate in Serializaiton?

9. What is transiant keyword?
10. What is functional interface?
11. Is it possible to create lamda expression for not annoatated @FunctionalInterface class?
12. Difference between Lamda expresson and annonomous class?
13. Why do we have static methods in Interface?
14. Why we have private methods in Interface?
15. Difference between Abstract class and Interface?

16. What are Flat maps?
https://www.javatpoint.com/flatmap-method-in-java-8


We can say that the flatMap() method helps in converting Stream<Stream<T>> to Stream<T>.

It performs flattening (flat or flatten) and mapping (map), simultaneously.
The Stream.flatMap() method combines both the operations i.e. flat and map.

flatMap() = Flattening (flat)+ mapping (map)  

Flattening is the process of converting several lists of lists and merge all those lists to create a single list containing all the elements from all the lists.

Flattening Example:

Before Flattening: [[1, 2, 3, 4], [7, 8, 9, 0], [5, 6], [12, 18, 19, 20, 17], [22]]

After Flattening: [1, 2, 3, 4, 7, 8, 9, 0, 5, 6, 12, 18, 19, 20, 17, 22]




17. What is parallel Stream?

18. What is concurrent HashMap?
19. Static methods can be overloaded?
20. Static variable can be recreated in child class?

21. What happen when we delete an element in ArrayList?

22. Who Sets works internally?

23. How distinct Stream method works works?


24. Name some Marker Interfaces?
25. Name some FunctionalInterface?

26. Explain Java 8 Features?

27. What is class Loader? and Types of class loaders?

28. Difference between JVM, JDK and JRE

29. How do you delete elements from List.

30. Object methods?

31. Why do we have yield methods in Object class?

32. Why do we have notify methods in Object class?

33. Why do we have wait methods in Java class?

34. Explain all the object class methods.

35. Name some Design Patterns?

36. Explain every DS in Java in below format

Name | Underlaying DS | Max Null Elements | Allow Duplication | Follow insertion order | Insertion time | Deletation time | Updation Time | Creation Time |



37. When do we choose HashSet over LinkedHashSet?

HashSet:

- It provides constant-time performance for basic operations such as add, remove, contains, and size, assuming the hash function disperses the elements properly among the buckets.

- HashSet does not maintain any order of its elements. The elements are stored based on their hash codes, which may not follow any specific order.

- If you do not need to maintain the insertion order of elements and simply require fast set operations, HashSet is a good choice.


LinkedHashSet:

- It maintains a doubly-linked list of the entries in the set, in the order in which they were inserted. This allows traversal of the elements in the order in which they were added.

- LinkedHashSet inherits the constant-time performance of HashSet for basic operations.

- If you need to maintain the insertion order of elements and still require fast set operations, LinkedHashSet is suitable.
Use LinkedHashSet when you want to iterate over the elements in the order they were inserted, or when you need predictable iteration order.


38. Compare HashSet and LinkedHashSet


Sure, here's a concise comparison of HashSet and LinkedHashSet in tabular format:

| Criteria                      | HashSet                                       | LinkedHashSet                                 |
|-------------------------------|-----------------------------------------------|-----------------------------------------------|
| Internal Data Structure      | Hash Table                                    | Combination of Hash Table and Linked List    |
| Insertion Order              | No                                            | Yes                                           |
| Performance (Average Case)   | O(1) for add, remove, contains, size         | O(1) for add, remove, contains, size         |
| Performance (Iteration)      | Faster, as it doesn't maintain insertion order| Slower, as it maintains insertion order       |
| Memory Overhead              | Lower, as it doesn't maintain order          | Higher, due to additional linked list        |
| Use Cases                    | When order doesn't matter and speed is key    | When order of insertion needs to be retained |


39. Explain Underlaying functionality of LinkedHashSet?

40. Explain Underlaying functionality of HashSet?

41. Multiprocessing v/s Multithreading 
https://www.simplilearn.com/tutorials/java-tutorial/multithreading-in-java#:~:text=Multithreading%20in%20Java%20is%20an,way%20of%20executing%20a%20process.

Multithreading in Java is a similar approach to multiprocessing.
Instead of a physical processor, multithreading involves virtual and independent threads.

It assigns each process with one or more threads based on their complexity. Each thread is virtual and independent of the other. This makes process execution much safer. If a thread or two are terminated during an unexpected situation, the process execution will not halt.

42. What is a Thread in Java?
A thread is the smallest segment of an entire process. A thread is an independent, virtual and sequential control flow within a process. In process execution, it involves a collection of threads, and each thread shares the same memory. Each thread performs the job independently of another thread. 

43. Lifecycle of a Thread in Java. Explain each Lifecycle.

The lifecycle of each thread in Java has five different stages. You will look into each one of those stages in detail. The Stages of the Lifecycle are mentioned below.

New:
The first stage is "New". This stage is where it initiates the thread. After that, every thread remains in the new state until the thread gets assigned to a new task.

Runnable:
The next stage is the runnable stage. Here, a thread gets assigned to the task and sets itself for running the task. 

Running:
The third stage is the execution stage. Here, the thread gets triggered as control enters the thread, and the thread performs a task and continues the execution until it finishes the job. 

Waiting:
At times, there is a possibility that one process as a whole might depend on another. During such an encounter, the thread might halt for an intermediate result because of its dependency on a different process. This stage is called the Waiting Stage.

Dead:
The final stage of the process execution with Multithreading in Java is thread termination. After it terminates the process, the JVM automatically declares the thread dead and terminates the thread. This stage is known as the dead thread stage.

44. In how many ways do you create a Thread in Java?

45. Methods of Multithreading in Java

start()
currentThread()
run()
isAlive()
sleep()
yield()
suspend()
resume()
interrupt()
destory()
stop()

46. Advantages of Multithreading in Java

47. What is Dead Lock?

48. Explain Consumer and Producer Problem?

49. Explain Modren ways to handle Multithreading.

50. Explain Streams?

Main Characteristics:

Sequence of Elements:
A Stream represents a sequence of elements. It can be finite or infinite.

Functional Style Operations: Streams support functional-style operations such as filter, map, reduce, and more.
Lazy Evaluation: Streams perform operations lazily. Intermediate operations are not evaluated until a terminal operation is invoked.
Immutable: Streams do not modify the source data. Instead, they produce new streams with the transformed data.
Support for Sequential and Parallel Processing: Streams can be processed sequentially or in parallel, offering enhanced performance for parallelizable operations.


Intermediate and Terminal Operations:

Intermediate operations (e.g., filter, map) transform the elements of a stream and return a new stream.
Terminal operations (e.g., forEach, collect) produce a result or a side effect, causing the stream to be consumed. After a terminal operation, a stream cannot be reused.


What is a Java Stream, and what are its main characteristics?
How do you create a Stream from different data sources in Java?
Explain the difference between intermediate and terminal operations in Java streams.
How do you handle exceptions within Java streams?
What are some common intermediate operations you can perform on a Stream?
How do you use the map() function in Java streams?
Explain what lazy evaluation means in the context of Java streams.
How do you convert a Stream back to a Collection or an array in Java?
What is the purpose of the filter() operation in Java streams?
How do you handle parallel streams in Java, and what are some considerations when using them?



// Each elements to List
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);














>>>>>>> Stashed changes




<<<<<<< Updated upstream
@Immutable
@ReadOnlyRepository<T, ID>
=======
>>>>>>> Stashed changes
