

Note: @Autowired won't throws Undefined Bean Defination unless the class itself is a bean.

public class HomeController {

	@Autowired
	private EmpService empService;

}

Above code won't throw Exception as the HomeController is not the bean.

If you annotate that class with @RestController then it will throw Exception.

Field empService in tech.suji.ctrl.HomeController required a bean of type 'tech.suji.service.EmpService' that could not be found.

The injection point has the following annotations:
	- @org.springframework.beans.factory.annotation.Autowired(required=true)
	
3 ways to handle it:
--------------------
1. Create a bean
2. Remove Annotation which create bean with the class
3. @Autowired(required = false)
	private EmpService empService;
	
	When you use: @Autowired(required = false) and try to add that dependency. You will face below exception.
	
	Caused by: java.lang.NullPointerException: Cannot invoke "tech.suji.service.EmpService.getName()" because "this.empService" is null.
	

If two or more beans found
---------------------------
Field empService in tech.suji.ctrl.HomeController required a single bean, but 2 were found:

Action:
Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed






Constructor-based Dependency Injection
---------------------------------------
The Spring team generally advocates constructor injection, as it lets you implement application components as immutable objects and ensures that required dependencies are not null.

If we have one or more beans.

private EmpService empService;
	
	public HomeController(@Qualifier("empMongoService") EmpService empService) {
		this.empService = empService;
	}
	
Dependency Injection (DI) in Spring Boot
-----------------------------------------

1. Constructor Injection
2. Setter Injection
3. Field Injection (Not Recommended)



1. Constructor Injection
------------------------
public HomeController(@Autowired(required = false) EmpService empService) {
	this.empService = empService;
}

If we don't want to automatically autowired. If we do not mention the Autowired rquired is false, it will never throw an error if the bean not found.


2. Setter Injection
--------------------
@Autowired
public void setEmpService(@Qualifier(value = "empMySqlService") EmpService empService) {
	System.out.println("Inside Setter Injection...");
}

We can use @Autowired annotation upon the method. The method will invoked at before the application get started. So, we can initialize our bean using that parameter. First constructor will be executed, then after the creation of the bean setter method will executed.



3. Field Injection (Not Recommended)



Configuration Properties
------------------------
https://www.baeldung.com/configuration-properties-in-spring-boot


@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "employee")
@ToString
@AllArgsConstructor
@Getter
public final class DemoConfig {
	private final String name;
	private final int age;
	private final double salary;
	private final Set<String> pets;
	private final boolean active;	
	private final Set<Acc> accounts;
}



employee:
  name : Sujith
  age: 27
  salary: 50000.99
  pets:
    - Dog
    - Cat
    - Elephant
  accounts:
    - acc-no: 101
      bank-name: SBI
    - acc-no: 102
      bank-name: HDFC




Using @ConfigurationProperties on a @Bean Method

@Configuration
public class ConfigProperties {

    @Bean
    @ConfigurationProperties(prefix = "item")
    public Item item() {
        return new Item();
    }
}



In Spring Boot 3 if there’s a single parameterized constructor, then constructor binding is implied and we don’t need to use the annotation. But in case of multiple constructors, we must annotate the preferred one with @ConstructorBinding.





@SpringBootApplication is a convenience annotation that adds all of the following:

@Configuration: Tags the class as a source of bean definitions for the application context.

@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

@ComponentScan: Tells Spring to look for other components, configurations, and services in the hello package, letting it find the controllers.



---
@Async
---------
- It must be applied to public methods only.
- Self-invocation — calling the async method from within the same class — won’t work.
- Return type must be void or Future<T>.
- Note: The Executor By default, Spring uses a SimpleAsyncTaskExecutor to actually run these methods asynchronously.


But we can override the defaults at two levels: the application level or the individual method level.

Individual method level:

@Configuration
@EnableAsync
public class SpringAsyncConfig {
    
    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}


@Async("threadPoolTaskExecutor")
public void asyncMethodWithConfiguredExecutor() {
   //...
}


The application level:

@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {
   @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
















Swagger OPEN API 3
-------------------

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.2.0</version>
</dependency>

http://localhost:8080/v3/api-docs
http://localhost:8080/v3/api-docs.yaml

springdoc.api-docs.path=/api-docs
http://localhost:8080/api-docs.yaml

http://localhost:8080/swagger-ui/index.html
springdoc.swagger-ui.path=/swagger-ui-custom.html
springdoc.swagger-ui.operationsSorter=method

Generate Documentation Using @ControllerAdvice and @ResponseStatus inside GlobalControllerExceptionHandler.

@Operation(summary = "Get a book by its id")
@ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Found the book", 
    content = { @Content(mediaType = "application/json", 
      schema = @Schema(implementation = Book.class)) }),
  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
    content = @Content), 
  @ApiResponse(responseCode = "404", description = "Book not found", 
    content = @Content) })
@GetMapping("/{id}")
public Book findById(@Parameter(description = "id of book to be searched") 
  @PathVariable long id) {
    return repository.findById(id).orElseThrow(() -> new BookNotFoundException());
}



Application.YAML Cheat
-------------

spring:
  data:
    mongodb:
      uri: mongodb+srv://sujith:NvrStle#22@cluster0.7usugpb.mongodb.net/wise-words?retryWrites=true&w=majority
      auto-index-creation: true
springdoc:
  pathsToMatch: /api/**

  
logging:
  level:
    org:
      springframework:
        data:
          mongodb:
            core:
              MongoTemplate: DEBUG



Annotations
-----------
@Configuration
@EnableMongoRepositories("tech.suji.wisewords.repos")
@EnableMongoAuditing(dateTimeProviderRef = "auditingDateTimeProvider")

@RestControllerAdvice(annotations = RestController.class)

 @ExceptionHandler(NotFoundException.class)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  
   @ApiResponse(responseCode = "4xx/5xx", description = "Error")

@RestController = @Controller + @ResponseBody

@Controller returns view resolver name.
@ResponseBody returns content


import org.springframework.data.mongodb.core.mapping.Document;
@Document



import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
    @CreatedDate
	  @Version
  @LastModifiedDate
  
  
  
@Component
public class QuoteListener extends AbstractMongoEventListener<Quote> {

	@Autowired
    private PrimarySequenceService primarySequenceService;


    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Quote> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(primarySequenceService.getNextValue());
        }
    }

}


package tech.suji.wisewords.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import tech.suji.wisewords.domain.PrimarySequence;


@Service
public class PrimarySequenceService {

    private static final String PRIMARY_SEQUENCE = "primarySequence";

    private final MongoOperations mongoOperations;

    public PrimarySequenceService(final MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long getNextValue() {
        PrimarySequence primarySequence = mongoOperations.findAndModify(
                query(where("_id").is(PRIMARY_SEQUENCE)),
                new Update().inc("seq", 1),
                options().returnNew(true),
                PrimarySequence.class);
        if (primarySequence == null) {
            primarySequence = new PrimarySequence();
            primarySequence.setId(PRIMARY_SEQUENCE);
            primarySequence.setSeq(10000);
            mongoOperations.insert(primarySequence);
        }
        return primarySequence.getSeq();
    }

}



----------------------

http://localhost:8761/eureka/apps/USER

RedirectingEurekaHttpClient  : Request execution error. endpoint=DefaultEndpoint{ serviceUrl='http://localhost:8761/eureka/}, exception=java.net.ConnectException: Connection refused: no further information stacktrace=jakarta.ws.rs.ProcessingException: java.net.ConnectException: Connection refused: no further information
	at org.glassfish.jersey.client.internal.HttpUrlConnector.apply(HttpUrlConnector.java:270)
	

RetryableEurekaHttpClient    : Request execution failed with message: java.net.ConnectException: Connection refused: no further information


RedirectingEurekaHttpClient  : Request execution error. endpoint=DefaultEndpoint{ serviceUrl='http://localhost:8761/eureka/}, exception=java.net.ConnectException: Connection refused: no further information stacktrace=jakarta.ws.rs.ProcessingException: java.net.ConnectException: Connection refused: no further information

DiscoveryClient    : DiscoveryClient_USER/Sujith.bbrouter:user:8080 - registration status: 204


GATE WAY
--------
Gateway running on:
NettyWebServer  : Netty started on port 9191

Without custom router:
spring:
  application:
    name: API-GATEWAY
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true

http://hocalhost:8080/users
http://hocalhost:8080/users/{id}


http://hocalhost:8765/USER-SERVICE/users

spring.cloud.gateway.discovery.locator.enabled=true



http://hocalhost:8080
http://localhost:8765/USER-SERVICE

http://localhost:8081/todos
http://localhost:8765/TODO-SERVICE/todos

Custom Routes
--------------

http://hocalhost:8080/users/{id}
Instead of: http://hocalhost:8765/user-service/users/{id}
We want : http://hocalhost:8765/users/{id}

How?

spring:
  application:
    name: API-GATEWAY
  cloud:
    gateway:
      discovery:
        locator:
          enabled: false
          lower-case-service-id: false



.route(p -> p.path("/todos/**")
			 .uri("lb://todo-service/**"))		  

http://localhost:8765/todos/<content>
Gateway router match:
http://localhost:8765/todo-service/todos/<content>
Final call:
http://todo-service/todos/<content>


Actual-url
http://hocalhost:8765/users/{id}

Gateway url
http://hocalhost:8765/user-service/users/{id}

Modified Url:
http://hocalhost:8765/user/{id}

Modified Url2:
http://hocalhost:8765/sujith/{id}


Easy to Remember Trick
-----------------------

route(p -> p.path("/<base-url>/**").uri("lb://<service-name>/**"))

Example:
route(p -> p.path("/auth/**").uri("lb://auth-service/**"))
route(p -> p.path("/todos/**").uri("lb://todo-service/**"))


https://www.baeldung.com/spring-cloud-custom-gateway-filters

https://medium.com/@rajithgama/spring-cloud-gateway-security-with-jwt-23045ba59b8a

https://github.com/Java-Techie-jt/jwt-apigateway-security/blob/main/swiggy-gateway/src/main/resources/application.yml

https://www.youtube.com/watch?v=MWvnmyLRUik


Resilience4j
------------

Resilience4j's circuit breaker pattern is used to prevent cascading failures in systems that rely on external services. It acts like a protective shield, isolating faulty services and preventing them from bringing down the entire system.

Here's how it works:

Monitoring: The circuit breaker continuously monitors calls made to an external service. It tracks successes and failures based on a configured window (like the last 10 calls or the last 5 seconds).

Tripping the Switch: If the failure rate exceeds a defined threshold within the window, the circuit breaker trips. This means it enters an "OPEN" state.

Isolating the Fault: In the OPEN state, the circuit breaker rejects all subsequent calls to the service. This prevents further failures from cascading and overwhelming the system.

Recovery Attempt (Half-Open): After a configured period (wait time), the circuit breaker enters a "HALF_OPEN" state. It allows a single call to pass through to check if the service has recovered.

Reset or Repeat:  If the call in the HALF_OPEN state succeeds, the circuit breaker resets to the CLOSED state, allowing normal calls again. If the call fails, the circuit breaker trips back to OPEN and the cycle repeats.

By using a circuit breaker, you can:

Improve fault tolerance: The system can gracefully degrade when a service is unavailable, instead of crashing entirely.
Protect resources: By isolating failures, you prevent wasted calls to a failing service, saving system resources for other operations.
Promote faster recovery: The automatic retry mechanism in the HALF_OPEN state helps the system identify when the service is back online and resume normal operation quickly.
Overall, Resilience4j's circuit breaker pattern is a powerful tool for building robust and resilient applications, especially those that interact with external dependencies.



Rate Limmiter:
A rate limiter is a tool used in software development to control the rate of incoming requests or operations to a system within a certain threshold. It restricts the number of requests a user or client can make in a given period of time. This is typically done to prevent abuse, protect against resource exhaustion, maintain quality of service, and ensure fair usage of system resources.
