


1. Local Variable Type Inference
2. copyOf() method in List, Map and Set.
java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection).
3. toUnmodifiable*()
java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set.
4. Optional*.orElseThrow()
5. Time-Based Release Versioning

1. Local Variable Type Inference

var message = "Hello, Java 10";
var idToNameMap = new HashMap<Integer, String>();

**Note**
It cannot be used for member variables, method parameters, return types, etc – the initializer is required as without which compiler won’t be able to infer the type.
Note that this feature is available only for local variables with the initializer.

**Note**
- Cannot use 'var' on variable without initializer.
	var n;	// error
- Cannot initialize; with null.
	var emptyList = null;	// error
- Cannot be use as instance variables.
	public var = "hello";	// error
- Lambda expression needs explicit target type, and hence var cannot be used
	var p = (String s) -> s.length() > 10; // error
- Cannot use to initialize array
	var arr = { 1, 2, 3 };

Guidelines for Using var:
- Not to unknown return types
	var result = obj.prcoess();
- Not for long streams
	var x = emp.getProjects.stream()
  .findFirst()
  .map(String::length)
  .orElse(0);
- Not without specific type in <>
	var empList = new ArrayList<>();
- Not to store anonymous class instance
	var obj = new Object() {};



2. static copyOf() method in List, Map and Set.
	It returns the unmodifiable copy of the given Collection.
	Any attempt to modify such a collection would result in UnsupportedOperationExceptionruntime exception.
	
	List<Integer> copyList = List.copyOf(someIntList);
	
	
	
3. toUnmodifiable*(), *List,Set,Map

toUnmodifiableList()
toUnmodifiableSet()
toUnmodifiableMap()

java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set.

List<Integer> evenList = someIntList.stream()
      .filter(i -> i % 2 == 0)
      .collect(Collectors.toUnmodifiableList());



4. Optional*.orElseThrow(), *Int,Long,Double
	orElseThrow()which doesn’t take any argument and throws NoSuchElementExceptionif no value is present
	Exception in thread "main" java.util.NoSuchElementException: No value present
	Example: 
	Optional<Object> box = Optional.ofNullable(null);
	box.orElseThrow();
	
	
5. Time-Based Release Versioning (JEP 322)
	With the adoption of the time-based release cycle, Oracle changed the version-string scheme of the Java SE Platform and the JDK, and related versioning information, for present and future time-based release models. The new pattern of the Version number is $FEATURE.$INTERIM.$UPDATE.$PATCH.


Recap:

Java 10 Features

1. Local Variable Type Inference. var name = "Sujith"
2. static copyOf() method in List, Map and Set. Returns Unmodifiable List/Map/Set.
	
	v10 static <E> List<E>	copyOf​(Collection<? extends E> coll)
	v9 	static <E> List<E> of​(E... elements)
	
	- The List.of(v9) and List.copyOf(v10) static factory methods provide a convenient way to create unmodifiable lists.
	- Calling any mutator method on the List will always cause UnsupportedOperationException to be thrown.
	
3. staic toUnmodifiable*(), *List,Set,Map in stream Collectors class.
4. Optional*.orElseThrow(). if null throws NoSuchElementException.
5. Time-Based Release Versioning.
	The new pattern of the Version number is $FEATURE.$INTERIM.$UPDATE.$PATCH.