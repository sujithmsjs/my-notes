# Server Settings
```properties
server.port=8081
spring.application.name=Project_Name
```

# H2 DB Datasource
```properties
### Data Source ###
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sujith
spring.datasource.password=password

### JPA Props ###
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto = create

### H2 Database Settings ###
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.h2.console.enabled=true
```


# MySQL Datasource
```properties
### MySQL Datasource ###
spring.datasource.url=jdbc:mysql://localhost:3306/nitro
spring.datasource.username=root
spring.datasource.password=apple
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Settings
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
# Swagger
```properties
### OPEN API URL ###
# Open API Available at http://localhost:8080/api-docs/
springdoc.api-docs.path=/api-docs

### SWAGGER UI ###
# Swagger UI Available at http://localhost:8080/swagger-ui-custom.html
springdoc.swagger-ui.path=/swagger-ui-custom.html
```
# JPA Props
```properties
# JPA Props
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto = create

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto = create

spring.jpa.defer-datasource-initialization=true
```

# Spring Security
```
spring.security.user.name = sujith
spring.security.user.password = 1234
```
# Hibernate Settings
```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
# Loggin Properties
```properties
# Logging Settings

logging.level.root=INFO
logging.level.springframework.context=debug
logging.level.com.suji.crudrepo=DEBUG
logging.level.org.springframework.context.config=DEBUG
```

# DateTimeFormatters
```properties
spring.mvc.format.date=yyyy-MM-dd
spring.mvc.format.date-time=yyyy-MM-dd HH:mm:ss
spring.mvc.format.time=HH:mm:ss
```

# Emai
```properties
spring.main.banner-mode=off

spring.mail.protocol=smtp
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=
spring.mail.password=
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```