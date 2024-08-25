spring.config.import="configserver:http://localhost:8081"

spring.config.import="optional:configserver:http://localhost:8081"

spring:
	profiles:
		active: git

	cloud:
		config:
			server:
				git: 
					uri:"https://github.com/eazybytes/eazybytes-config.git"
					default-label:main(Branch)
					timeout: 5(Secounds)
					clone-on-sart:true()
					force-pull: true
					
spring.application.name=config-server

server.port: 8888
# spring.cloud.config.server.git.uri: file://${user.home}/config-repo

# Default GIT to Native
spring.profiles.active=native
spring.cloud.config.server.native.search-locations="file:///C://Users//sujith.manchala//Desktop//config"
logging.level.org.springframework.cloud.config.server: trace


o.s.c.c.c.ConfigServerConfigDataLoader  [0;39m [2m:[0;39m Fetching config from server at : http://localhost:8888

- ConfigClientFailFastException
- InvalidDefinitionException

com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.springframework.context.expression.StandardBeanExpressionResolver and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: com.sujithms.BookDTO$$SpringCGLIB$$0["$$beanFactory"]->org.springframework.beans.factory.support.DefaultListableBeanFactory["beanExpressionResolver"])





@ConfigurationPropertiesScan + @ConfigurationProperties(prefix = "books")

@ConfigurationProperties(prefix = "books")

---


spring:
  rabbitmg:
    host: "localhost"
	post: 5672
	username: "guest"
	password: "guest"


LIVENESS AND READINESS PROBES
------------------------------

LIVENESS
--------
- Sending the singles(HEART BEAT)
- Is this container alive?
- /actuator/health/liveness

READINESS PROBES
----------------
- Is this container ready to receive network traffic?
- /actuator/health/readiness


<plugin>
  <groupId>com.google.cloud.tools</groupId>
  <artifactId>jib-maven-plugin</artifactId>
  <version>2.8.0</version>
  <configuration>
    <to>
      <image>gcr.io/PROJECT/IMAGE</image>
    </to>
  </configuration>
</plugin>


=============================================


---------------
MY SQL DOCKER
---------------


docker run -p 3306:3306 `
--name accountsdb `
-e MYSQL_ROOT_PASSOWRD=root`
-e MYSQL_DATABASE=accounts`
-d // Detached mode
mysql // Docker Image Name.

docker run -p 3306:3306 --name mydb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=emp -d mysql











































