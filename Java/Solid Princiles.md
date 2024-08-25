Solid Princiles
---------------

SOLID is a set of five principles introduced by Robert C. Martin to guide object-oriented design.
These principles promote creating well-structured, flexible, and maintainable code. Here's a breakdown of each principle:

Robert C. Martin, also widely known as "Uncle Bob", is a prominent figure in the software engineering world.

**(S)ingle Responsibility**
**(O)pen-Closed**
**(L)iskov Substitution**
**(I)nterface Segregation**
**(D)ependency Inversion**

1. Single Responsibility Principle (SRP):

A class should have one, and only one, reason to change. This means each class should have a focused purpose and avoid handling multiple unrelated functionalities.

2. Open-Closed Principle (OCP):

Software entities (classes, modules) should be open for extension but closed for modification. New functionalities should be added through inheritance or composition without changing existing code.

3. Liskov Substitution Principle (LSP):

Objects of a superclass should be replaceable with objects of its subclasses without altering the program's correctness. Subclasses should not break the expectations set by the base class.


4. Interface Segregation Principle (ISP):

Clients shouldn't be forced to depend on methods they don't use. Large interfaces with many methods can be broken down into smaller, more specific interfaces.

5. Dependency Inversion Principle (DIP):
High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details, details should depend on abstractions. This promotes loose coupling and easier testing.
