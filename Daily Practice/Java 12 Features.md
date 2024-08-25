# Java 12 Features

Overview
1. New String methods(indent, transformed)
2. New static mismatch methods in Files class
3. Teeing Collector: static teeing method in Collectors class. 
4. CompactNumberFormat
5. Switch Expressions
6. Pattern Matching for instanceof

1. String Class New Methods
	- transform
	Ex:
		text = text.indent(4);
		text = text.indent(-10);
	- indent
	Ex:
		String transformed = text.transform(value ->
		  new StringBuilder(value).reverse().toString()
		);
	
2.  new mismatch method in the nio.file.Files utility class


	Path filePath1 = Files.createTempFile("file1", ".txt");
    Path filePath2 = Files.createTempFile("file2", ".txt");
    Files.writeString(filePath1, "Java 12 Article");
    Files.writeString(filePath2, "Java 12 Article");

    long mismatch = Files.mismatch(filePath1, filePath2);

3. Teeing Collector
	- It is a composite of two downstream collectors.
	- Every element is processed by both downstream collectors.
	- Then their results are passed to the merge function and transformed into the final result.
	
	teeing() is a static method of the Collectors class that is used to return a Collector combining the results of two Collector operations.	

	static Collector teeing(Collector downstream1, Collector downstream2, BiFunction merger)
	
	The example usage of teeing collector is counting an average from a set of numbers. The first collector parameter will sum up the values, and the second one will give us the count of all numbers. The merge function will take these results and count the average:
	
	double mean = Stream.of(1, 2, 3, 4, 5)
		.collect(
			Collectors.teeing(
				Collectors.teeing(Collectors.summingDouble(i -> i), // Down Stream1
				Collectors.counting(),								// Down Stream2
				(sum, count) -> sum / count)						// Merge Function
			)
		);
		

4. Compact Number Formatting
	public static NumberFormat getCompactNumberInstance(Locale locale, NumberFormat.Style formatStyle)
	
	java.lang.Object
		java.text.Format
			java.text.NumberFormat
				java.text.CompactNumberFormat(v12)
	
	NumberFormat.Style: LONG, SHORT	
	
	NumberFormat likesShort = 
      NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
	  
	  
5. Switch Expressions 

	String typeOfDay = switch (dayOfWeek) {
						case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
						case SATURDAY, SUNDAY -> "Day Off";
					};
	
	- More compact and readable.
	- Break statements not needed.
	- We can assign a switch statement directly to the variable.
	- It’s also possible to execute code in switch expressions without returning any value
	- More complex logic should be wrapped with curly braces

6. Pattern Matching for instanceof 

	// Old version
	Object obj = "Hello World!";
	if (obj instanceof String) {
		String s = (String) obj;
		int length = s.length();
	}
	
	// New version
	if (obj instanceof String s) {
		int length = s.length();
	}
	
	