# Understanding Java 9 Modules

- Optional to Stream
- Immutable Set
- Try-With-Resources
	In java 7, an auto closable resource has to be both declared and initialized inside the try.
	try-with-resources functionality is to replace the traditional and verbose try-catch-finally block.
	In java 9, if the resource is referenced by a final or effectively final variable, a try-with-resources statement can manage a resource without a new variable being declared

- Diamond operator in conjunction with anonymous inner classes

	FooClass<Integer> fc = new FooClass<>(1) {
		// anonymous inner class
	};
	
- Interface Private Method

- JShell Command Line Tool

- Modular System – Jigsaw Project
- A New HTTP Client
	The new API is located under the java.net.http package.
	The API uses the Builder pattern
	HttpRequest request = HttpRequest.newBuilder()
		.uri(new URI("https://postman-echo.com/get"))
		.GET()
		.build();
- Process API has been improved



Try with resource

```java
public class DemoHttpClient {
	public static void main(String[] args) {
		A a = new A();
		try(a){
			System.out.println("This is in Try with Resource block");
		}catch (Exception e) {
			System.out.println("I am trying to handling the error man!");
		}
		System.out.println("Successful...");
	}
}

class A implements AutoCloseable{
	@Override
	public void close(){
		System.out.println("A is going to be closed.");
		throw new RuntimeException("Can't close this resource man!");
	}
}
```