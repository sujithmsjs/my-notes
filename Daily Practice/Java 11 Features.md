# Java 11 Features

1. New String Methods(isBlank, lines, strip, repeat)
	- String strip()
	- String stripLeading()
	- String stripTrailing()
	- boolean isBlank()
	- Stream<String> lines()
	- String repeat​(int count)
	
	
2. New File Methods(readString, writeString)
3. Collection to an Array(toArray method)
	String[] sampleArray = sampleList.toArray(String[]::new)

4. The static not method in Predicate class
	List withoutBlanks = sampleList.stream()
		.filter(Predicate.not(String::isBlank))
		.collect(Collectors.toList());

5. Local-Variable Syntax for Lambda

	var catsList = new ArrayList<Cat>();
	List<Integer> aniList = catsList.stream().map((Animal n) -> n.getA()).collect(Collectors.toList());
	System.out.println(aniList);

	Now it is possilbe, but use of it:
	List<Integer> aniList = catsList.stream().map((var n) -> n.getA()).collect(Collectors.toList());

6. Running Java Files
	$ java HelloWorld.java -> It will complete and run.
7. HTTP Client
	Api to do rest calls.

# 1. New String Methods:
isBlank, lines, strip, stripLeading, stripTrailing, and repeat.

Stream<String>	lines():
Returns a stream of lines extracted from this string, separated by line terminators.

String	strip():
Returns a string whose value is this string, with all leading and trailing white space removed.

String	stripLeading():	
Returns a string whose value is this string, with all leading white space removed.

String	stripTrailing():
Returns a string whose value is this string, with all trailing white space removed.

boolean isBlank():
Returns true if the string is empty or contains only white space codepoints, otherwise false.

String repeat​(int count):
Returns a string whose value is the concatenation of this string repeated count times.


# 2. New File Methods
readString, writeString

public static String readString​(Path path) throws IOException:

Reads all content from a file into a string, decoding from bytes to characters using the UTF-8 charset. The method ensures that the file is closed when all content have been read or an I/O error, or other runtime exception, is thrown.


public static Path writeString​(Path path, CharSequence csq, OpenOption... options) throws IOException:

Write a CharSequence to a file. Characters are encoded into bytes using the UTF-8 charset.

# 3. Collection to an Array
default <T> T[] toArray​(IntFunction<T[]> generator)

List sampleList = Arrays.asList("Java", "Kotlin");
String[] sampleArray = sampleList.toArray(String[]::new);
assertThat(sampleArray).containsExactly("Java", "Kotlin");




# 4. The Not Predicate Method

static <T> Predicate<T>	not​(Predicate<? super T> target)	
Returns a predicate that is the negation of the supplied predicate.

List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
List withoutBlanks = sampleList.stream()
  .filter(Predicate.not(String::isBlank))
  .collect(Collectors.toList());

# 5. Local-Variable Syntax for Lambda
Support for using the local variable syntax (var keyword) in lambda parameters was added in Java 11.

We can make use of this feature to apply modifiers to our local variables, like defining a type annotation.

List<String> sampleList = Arrays.asList("Java", "Kotlin");

String resultString = sampleList.stream()
  .map((@Nonnull var x) -> x.toUpperCase())
  .collect(Collectors.joining(", "));
  
# 6. Running Java Files
we don’t need to compile the Java source files with javac explicitly anymore

$ java HelloWorld.java
Hello Java 11!

# 7. HTTP Client


```java
public class DemoHttpClient {

	public static void main(String[] args) {
		// Create an instance of HttpClient
		HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
				.connectTimeout(Duration.ofSeconds(20)).build();

		// Define the URL to which you want to send the GET request
		String url = "https://jsonplaceholder.typicode.com/users";

		// Create an HttpRequest with the specified URL
		HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		try {
			System.out.println("Request sent:");
			// Send the GET request and receive the response
			HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			// Print the HTTP status code
			System.out.println("Status Code: " + httpResponse.statusCode());

			// Print the response body
			System.out.println("Response Body:\n" + httpResponse.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("End");
	}
}
```

















