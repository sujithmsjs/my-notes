# Java 9 Features

### Interface Private Methods
### Try-With Resources
	- AutoClosable interface
	- Java 7 Resource Declared within resource block,  we can't put resource declared outside the try-with-resource.
	- FileOutputStream fileStream=new FileOutputStream("javatpoint.txt");  
        try(fileStream){  
	-  if we execute the above program using Java 9 compiler, it will execute nicely without any compile error.
	
### Anonymous Classes Improvement:
	-- diamond operator with anonymous classes
Home
Dashboards
OBS-ecosystem
odeski-admin-api-qa-logs





### Java @SafeVarargs Annotation
It is an annotation which applies on a method or constructor that takes varargs parameters. It is used to ensure that the method does not perform unsafe operations on its varargs parameters.

### Java 9 Factory Methods

	- Java 9 Collection library includes static factory methods for List, Set and Map interface.
	- These methods are useful to create small number of collection.
	- sed to create unmodifiable instances of collections.
	- It is unmodifiable, so adding new element will throw java.lang.UnsupportedOperationException	
	-  Set.of() static factory method
### Java 9 New Version-String Scheme
	- Runtime.Version version = Runtime.version();       
### Java Shell Tool (JShell)
	- JShell is a REPL (Read Evaluate Print Loop)
	- jshell -v : to oepn the JShell
	
### Java 9 Stream API Improvement
	- takeWhile(Predicate)
	- 
	
Message changes from to NewValue

try {				
				
			}catch(Exception e) {
				log.info("Error inside Log Mgnt in Shifts" + e.getMessage());
			}
			
			git checkout -b ODesk-External-Admin-Ticket-Local-V2 origin/feature/ODesk-External-Admin-Ticket-Local-V2