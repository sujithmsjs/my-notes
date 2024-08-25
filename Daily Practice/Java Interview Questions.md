Java Interview Questions
------------------------

1. Access Modfiers

public: Accessible from anywhere.
protected: Accessible within the same package and subclasses (even if they are in different packages).
default (package-private): Accessible only within the same package.
private: Accessible only within the same class.

2. Non Access Modifers


static: Belongs to the class rather than any specific instance. It can be accessed without creating an instance of the class.

final: Cannot be overridden, modified, or extended. For variables, it makes the value unchangeable once assigned. For methods, it prevents overriding. For classes, it prevents inheritance.

abstract: Used to declare abstract methods or classes. Abstract methods have no implementation and must be overridden by subclasses. Abstract classes cannot be instantiated but can be subclassed.

synchronized: Ensures that only one thread can access a method or a block of code at a time, preventing race conditions in multithreaded environments.

volatile: Indicates that a variable's value may be changed asynchronously, typically by multiple threads, and should not be cached.

transient: Prevents a variable from being serialized when an object is converted into a byte stream (e.g., during serialization).

native: Indicates that a method is implemented in native code (code written in languages such as C or C++) and not in Java.

strictfp: Ensures that floating-point calculations produce the same results on all platforms, regardless of the underlying platform's floating-point behavior.

final strictfp: A combination of final and strictfp, ensuring both immutability and consistent floating-point behavior.


3. Access Mofiers part in inheritance.
Note: 
- Cannot reduce the visibility of the inherited method from Parent.
- Parent should have higher access

### 001. Is this work or Not?

class A {
	public void m1()  {
		System.out.println("m1 in A");
	}
}

class B extends A {
	@Override
	public void m1()  {
		System.out.println("m1 in B");
	}
}

-> Is this work if Subclass overriding method throws Checked Exception where as parents doesn't?
-> Is this work if Subclass overriding method throws Checked Exception where as parents doesn't?

### Find the Exception if you find any

class A {
	public void m1()  {
		System.out.println("m1 in A");
	}
}

class B extends A {

	@Override
	public void m1() throws NullPointerException {
		System.out.println("m1 in B");
	}
}

### Find the exception if any

class A {
	public void m1() throws ClassNotFoundException {
		System.out.println("m1 in A");
	}
}

class B extends A {
	@Override
	public void m1() {
		System.out.println("m1 in B");
	}
}

public class Basic__001 {
	public static void main(String[] args) {
		A a1 = new B();
		B b = new B();
		A a2 = new B();
		a1.m1();
		a2.m1();
		b.m1();
	}
}





4. Access Mofiers part in Packages.

5. Can over ride private/final methods.
6. What is Race condition with an examle.
7. What is Runtime polymorphism, Compile time polymorphism and Dynamic Method Dispatching.

8. Can we write try without catch?
9. Abstraction v/s Encapulation?
10. OOPS Principles

11. What is Volatile Keyword?

Imagine you have a variable that multiple threads might try to read from or write to at the same time. When a thread reads a variable, it might store that value in its own cache. If another thread changes the variable, the first thread might not immediately see that change because it's still using the old cached value.

The volatile keyword in Java helps solve this problem. When you declare a variable as volatile, it ensures that:

Any read of the variable will always return the most recent write by any thread.
Any write to the variable will immediately be visible to all other threads.
So, in simple terms, volatile ensures that when one thread changes the variable, all other threads know about it right away. It's like shouting out changes so everyone hears them immediately, rather than whispering them and waiting for others to notice.

In a multithreaded Java program, multiple threads may read and write to shared variables. When a thread reads a variable, it might store that value in its own cache. This is done for performance reasons since accessing the main memory can be slower compared to accessing the CPU cache. However, this caching mechanism can lead to issues when multiple threads are accessing shared variables concurrently.

12. Basic Definations:

Class: A class can also be defined as a blueprint from which you can create an individual object. Class doesn't consume any space.

Object: Any entity that has state and behavior is known as an object.

Inheritance: When one object acquires all the properties and behaviors of a parent object, it is known as inheritance. It provides code reusability. It is used to achieve runtime polymorphism.

Polymorphism: If one task is performed in different ways, it is known as polymorphism. In Java, we use method overloading and method overriding to achieve polymorphism.

Abstraction: Hiding internal details and showing functionality is known as abstraction. For example phone call, we don't know the internal processing.

Encapsulation: Binding (or wrapping) code and data together into a single unit are known as encapsulation. We can create a fully encapsulated class in Java by making all the data members of the class private. Now we can use setter and getter methods to set and get the data in it.

Coupling: Dependency of the one class on another class. You can use interfaces for the weaker coupling because there is no concrete implementation.

- Strong coupling: If a class has the dependency of details information of another class, there is strong coupling.

- Week coupling: By using Abstract class and Interfaces we can achive Week coupling.

Cohesion: cohesion refers to how closely related and focused the parts of a component (like a class or a package) are to each other. A component with high cohesion means that its parts work together to perform a single, well-defined task. On the other hand, a component with low cohesion means that its parts are not closely related and might be working on different tasks, or the same task in a scattered way.



13. Can we override private and static methods.

You cannot directly override private methods from a superclass in a subclass. This is because private methods are not visible to subclasses and thus cannot be overridden. Overriding is a concept where a subclass provides a specific implementation for a method that is already defined in its superclass.

14. Explain Types of Cloning, How to achive this in Java.
- Deep clone
- Shallow chole
- CloneNotSupportException

15. Define a few Math Methods.
- min(a, b)
- max(1,b)
- sqrt()
- pow()


16. Compilte Time polymorphism
If you overload a static method in Java, it is the example of compile time polymorphism.


Exception Handling:
-------------------
Checked Exceptons: The classes that directly inherit the Throwable class except RuntimeException and Error are known as checked exceptions.

Unchecked Exceptions: The classes that inherit the RuntimeException are known as unchecked exceptions.
- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException 


Error:

Error is irrecoverable. Some example of errors are OutOfMemoryError, VirtualMachineError, AssertionError etc.

What is the difference between checked and unchecked exceptions?
What happens behind the code int data=50/0;?
Why use multiple catch block?
Is there any possibility when the finally block is not executed?


What is exception propagation?

An exception is first thrown from the top of the stack and if it is not caught, it drops down the call stack to the previous method. If not caught there, the exception again drops down to the previous method, and so on until they are caught or until they reach the very bottom of the call stack. This is called exception propagation.

Note: By default Unchecked Exceptions are forwarded in calling chain (propagated).
Note: By default, Checked Exceptions are not forwarded in calling chain (propagated).



Call stack: It is static which contains all the calling methods in it. Main methods at botton and next method upon the main and recent method at the top.


What is the difference between the throw and throws keyword?
What are the 4 rules for using exception handling with method overriding?


Difference between final, finally and finalize?

https://www.javatpoint.com/difference-between-final-finally-and-finalize

finnal is the Keyword.
- final variable: final variable becomes constant and cannot be modified.
- final class: final class cannot be inherited.
- final method: cannot be overridden by sub class.


finally is the block, finally block runs the important code even if exception occurs or not. finally block cleans up all the resources used in try block.

finalize is the Object method. finalize method performs the cleaning activities with respect to the object before its destruction.





Exception Handling with Method Overriding in Java.

Rules:
1. If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.

2. Overriding methods can throw any unchecked (runtime) exceptions, regardless of whether the overridden method throws exceptions or not.

3. If a method is declared as final in the superclass, it cannot be overridden in the subclass, so exception handling rules for overriding don't apply.

Overriding Rules:
-----------------

1. You can't change the method singature.
- If you try to chane return type: he return type is incompatible error will be thrown.


Object 
<- Throwable
<- Exception
<- IOException
<- FileNotFoundException

| overridden method(Super class) | overriding method(sub class) | Error | | :----------------------------- | :--------------------------: | -------------: | | - | NullPointerException | No Error | | NullPointerException | - | No Error | | FileNotFoundException | - | No Error | | IOException | IOException | No Error | | FileNotFoundException | IOException | Not compatible | | FileNotFoundException | NullPointerException | No Error | | - | FileNotFoundException | Not compatible | | NullPointerException | FileNotFoundException | Not compatible | | IOException | FileNotFoundException | No Error | | | | | | | | |




Inner Classes:
--------------
1. Memeber Inner Class/ Non-Static Inner class
- A non-static nested class that is a member of its enclosing class.

2. Static Nested Class:
- A static nested class is similar to a member inner class, but it's static.

3. Local Inner Class
- Defined within a method or a scope block of another class.


4. Anynomouse Inner Class
- A class without a name that's defined and instantiated at the same time.



Map.Entry: Map.Entry is an inner interface of the Map interface.

------------------
EXCECUTION ORDER:
------------------

Static block (executed once when the class is loaded).
Non-static block (executed each time an instance is created, before the constructor).
Constructor (executed each time an instance is created).


Static Block:

-- Static blocks are executed only once when the class is loaded into memory, before any instance of the class is created or any static variable is accessed.

-- Static blocks are mainly used for initializing static variables or performing some one-time initialization tasks for the class.

-- If there are multiple static blocks in a class, they are executed in the order they appear in the code.



Non-Static Block (Instance Initializer Block):
Non-static blocks are executed each time an instance of the class is created, before the constructor is invoked.
They are mainly used for performing common initialization tasks that need to be executed for every instance of the class.
If there are multiple non-static blocks in a class, they are executed in the order they appear in the code, and they are executed before the constructor.



Constructor:
Constructors are executed after the instance initializer blocks and are used to initialize the instance variables and perform additional initialization tasks specific to each instance of the class.
Constructors are invoked each time an instance of the class is created using the new keyword.
If there are multiple constructors in a class, the constructor corresponding to the constructor invocation is executed.
Constructors can call other constructors using this() or super() but cannot be called directly from the code.



 There is context-switching between the threads. There can be multiple processes inside the OS, and one process can have multiple threads.
 
CHALLENGE - 7
--------------

RESILIENCY: Able to bounce back to normal position.

-> How do we avoid cascading failures?

- Cascading Failures
- Repil effect

-> How do we handle Greacefully with fallbacks?
- Fallback Mechanism

 
-> How to make our services self-healing capable

- Timeout
- Retries
- Self-healing capable.

Hystrix - Netflix
Resilience4J
- Lightweight
- Fault tolerance library
- Circuit breaker
- Fallback
- Retry
- Rate limit
- Blukhead



Docker
------
-d: Run container in background and print container ID
-it: Create an interactive container
-p: Map host port to container port
–name: Assign a name to the container
–rm: Automatically remove the container when it exits.



https://www.freecodecamp.org/news/how-to-dockerize-a-react-application/#:~:text=At%20this%20point%2C%20we%20have,Run%20the%20following%20command.&text=%2Dd%20runs%20the%20container%20in,running%20process%20on%20your%20terminal.

EDGE SERVER/API GATEWAY


CIRCUIT BREAKER PATTERN
-----------------------

- Safety device
- Short circuit
- Auto healing
- Circuit breaking
- Failing fast -> Prevents repil effect.

Advantages:
- Fail fast
- Fail gracefully -> Fall back mechanism

- Recover seamlessly

3 stages
--------
- CLOSED: Initially the circuti breaker starts with closed status and accepts client request.

Failure rate above the threshold will be in OEPN status. 


- HALF_OPEN:  Periodically circuit breaker checks if the issue is resolved by allowing few requests. Based on the results it will either go to CLOSED or OPEN.

- OPEN: If circuit breaker sees a threshold requests and failing, then it will OPEN the circuit which will make requests fail fast.

CLOSED -> OPEN: Failure rate above the threshold.
OEPN -> HALF_OPEN: After wait duration.
HALF_OPEN -> CLOSED: Failure rate above the threshold.
HALF_OPEN -> OPEN: Failure rate below the threshold.

How to implement:

#1. Add inside pom.xml

spring-cloud-starter-circuitbreaker-reactor-resilience4j


#2. Configuration

resilience4j.circuitbreaker:
	configs:
		default: <- Can be changed
			slidingWindowSize:0
			permittedNumberOfCallsInHalfOpenState:2
			failureRateThreshold:50
			waitDurationInOpenState:1000

#3. Add the circuit breaker inside GATE_WAY Server config.


slidingWindowSize: How many request it has to monitor in order to move to OPEN state.


#4.
/actuator/circuitbreaker
/actuator/circuitbreakerevent?name=accountCircuitBreaker


5. When we are using creating Rest API's inside the Gayway we have to use Mono or Flex as the return type.



Which dependency do we need to impl CircuitBreaker inside Gayway and in another microserices?
While overriding/overloading can we change the return type of the methods?


-----------------


Feign client + Circuit Breaker



cloud:
	openfeign:
		circuitbreaker:
			enable: ture
https://docs.spring.io/spring-cloud-openfeign/reference/spring-cloud-openfeign.html#spring-cloud-feign-circuitbreaker-fallback


/actuator/circuitbreakers <- It will show the all the circuit breakers
/actuator/circuitbreakerevents

------

Retry pattran
---------------

Exponentional Backoff















