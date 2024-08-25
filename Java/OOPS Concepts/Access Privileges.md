Attempting to assign weaker access privileges - Error in Java
As per the rule in overriding , you cannot apply weaker access specifier over a stronger access specifier.Suppose , your parent class has a method Display() with stronger access specifier like Public, then you cannot use weaker access specifier like private or public when you are overriding the Display() method.

Note :-

 Public is the 1st stronger access specifier
 Protected is the 2nd stronger access specifier
 Default is the 3rd stronger access specifier
 Private is the most weaker access specifier
 
 
class A {
    protected void m1(){ // 2nd
    System.out.println("Inside A's m1");
  }
}

class B extends A {
  @Override   
   void m1(){ // 3rd
    System.out.println("Inside B's m1"); 
  }
}

Clild Access privilege >= Parent Access privileges
Note: 
- Same Access privileges are always welcome.
- Child Access Privilege should be stronger.

------------------
| Parent | Child | 
-------------------
public(1)  | private(4) | Child is week so error
default (3) | private(4) | Child is week so error
protected(2)  | private(4) | Child is week so error


private(4)  | public(1) | Child is Strong so OK
default (3) | public(1) | Child is Strong so OK
protected(2)  | public(1) | Child is Strong so OK


public(1)  | protected(2) | Child is week so error
default (3) | protected(2) | Child is Strong so OK
private(4)  | protected(2) | Child is Strong so OK

public(1)  | default(3) | Child is week so error
protected (2) | default(3) | Child is week so error
private(4)  | default(3) | Child is Strong so OK


Can we override Private method?
Why Child method Access Privilege should be stronger?
Can we override final methods?




























