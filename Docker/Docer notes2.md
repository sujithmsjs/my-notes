To implement asynchronous programming in a Spring Boot application for calling these methods, you can utilize Java's CompletableFuture or Spring's @Async annotation.


@Autowired
Environment env;

env.getProperty("JAVA_HOME");
env.getProperty("MAVEN_HOME");


@ConfigurationProperties
------------------------
public record AccountContactInfoDto(

){
}

application.yml <- 8080

application_qa.yml
application_prod.yml

sping:
  config:
    activate:
	  on-profile: "qa"

spring:
	config:
		- "application.qa"
		- "application_prod"
		
		
---

Externalized Configuration
Activate Profile from extrenal location?
1. Command-line arguments[while running the jar file]
- Highest precidence than JVM system properties
- High precidence
Ex:
java -jar <jar-file> --<property>=<value>

2. JVM System properties
- Medium precidence
Ex:
java -D<property>=<value> -jar <jar-file>

3. Environment Variable
- Lower precidence than JVM sys props but higher than application.properties.

- Widely used for externalized configuration.
- SHOULD BE IN UPPERCASE
- .(DOT) with _(Underscore)
Windows:
env:BUILD_VERSION="1.3"; java -jar <jar-file>

- How to active profile from externalized scorce?


Drawbacks:
----------
- CLI arguments
- CACD Pipeliines
- Jenkings
- Granular access
- Security


Spring Cloud Config
-------------------
- A centralized configuration
- External properties
- You can choose where to store configs
-- DB
-- GIT
-- Local file system


Step 1:
dependencies
--------------
- CONFIG SERVER
- ACTUATOR

Step 2:
@EnableConfigServer

Step 3:
server.port=8071

Step 4:
Choose where to store data
- Classpath

spring:
	application:
		name: CONFIG-SERVER	

Step 5:
Create "config" folder in resources

Step 6:
Add props fils to config folder

<service_name>_<profile>.yml
Ex:
accounts.yml
accounts-prod.yml
accounts-qa.yml


Step 7:
Set spring cloud config profile to native.

spring:
	application:
		name: "config-server"
	profiles:
		active: native
	cloud:
		config:
			server:
				native:
					search-location:"classpath:/config"

Step 8:
Check API that configs are working fine or not
Ex:
localhost:8071/accounts/prod
localhost:8071/accounts/qa
localhost:8071/accounts/default

w














		






































