Springboot

@Configuration
@ComponentScan(basePackages = "com.acme")
@Bean and @Configuration

@Bean(initMethod = "init")
@Bean(destroyMethod = "cleanup")


@Bean
@Scope("prototype")
@Description("Provides a basic example of a bean")
public Encryptor encryptor() {
	// ...
}

@Bean("myThing")
@Bean({"dataSource", "subsystemA-dataSource", "subsystemB-dataSource"})

@Bean(initMethod = "init")
public BeanOne beanOne() {
	return new BeanOne();
}

@Bean(destroyMethod = "cleanup")
public BeanTwo beanTwo() {
	return new BeanTwo();
}


@Configuration
@Import(ConfigA.class)
public class ConfigB {

	@Bean
	public B b() {
		return new B();
	}
}


@Profile


@EventListener
@EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})


Asynchronous Listeners

@EventListener
@Async
public void processBlockedListEvent(BlockedListEvent event) {
	// BlockedListEvent is processed in a separate thread
}

Ordering Listeners

@EventListener
@Order(42)
public void processBlockedListEvent(BlockedListEvent event) {
	// notify appropriate parties via notificationAddress...
}



@Component
public class MyBean {

	private final Resource template;

	public MyBean(@Value("${template.path}") Resource template) {
		this.template = template;
	}

	// ...
}



record Person(@Size(min = 1, max = 10) String name) {
}

@Validated
public class MyService {

	void addStudent(@Valid Person person, @Max(2) int degrees) {
		// ...
	}
}

@PersistenceContext


@Configuration
class ApplicationConfiguration {

  @Bean
  MongoClient mongoClient() {
      return MongoClients.create("mongodb://localhost:27017");
  }

  @Bean
  MongoOperations mongoTemplate(MongoClient mongoClient) {
      return new MongoTemplate(mongoClient, "geospatial");
  }
}