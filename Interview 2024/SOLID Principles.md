[Solid principles](https://www.freecodecamp.org/news/solid-principles-explained-in-plain-english/)

# SOLID Principles

To create understandable, readable, and testable code that many developers can collaboratively work on.
----------------
1. S Single Responsibility Principles
2. O Open close Principles
3. Liskov Substitution Principles
4. Interface Seggregation Principles
5. Dependency Inversion Principle



### 1. S Single Responsibility Principles

The Single Responsibility Principle states that a class should do one thing and therefore it should have only a single reason to change.


```java
class Book{}

class Invoice(){
	printInvoice(); // Format, Fields, Cost
	savetoBD();     // Which DB?
	calculateCost();// How much GST on it?
}

Instead

class InvoicePrinter {
}
class InvoicePersistence{
}
```

- We can divide the class into multiple classes so that each class can have the meaning full methods that have only one responsibility to change.

- If a class have multiple responsibilies it will lead to team inconsistency.
- And It will arise more merge conflicts.




### 2. O Open close Principles

The Open-Closed Principle requires that classes should be open for extension and closed to modification.

Modification means changing the code of an existing class, and extension means adding new functionality.


### 3. Liskov Substitution Principles
The Liskov Substitution Principle states that subclasses should be substitutable for their base classes.

This means that, given that class B is a subclass of class A, we should be able to pass an object of class B to any method that expects an object of class A and the method should not give any weird output in that case.

### 4. Interface Seggregation Principles

Segregation means keeping things separated, and the Interface Segregation Principle is about separating the interfaces.

The principle states that many client-specific interfaces are better than one general-purpose interface. Clients should not be forced to implement a function they do no need.

### 5. Dependency Inversion Principle


The Dependency Inversion principle states that our classes should depend upon interfaces or abstract classes instead of concrete classes and functions.

```java
interface Shape {

}

class AreaFinder {
    public double findArea(Shape shape){

    }
}
```