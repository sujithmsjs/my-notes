# Demo Sprnigboot project
### November 13, 2022


### File Structure
```pre
+ pom.xml
+ src\ 
	+ \main\resources
		|---  application.properties
	+ \main\resources\templates
		|---  car.html
		|---  home.html
	+ \main\java\com\sujith\demo
		|---  DemoApplication.java
	+ \main\java\com\sujith\demo\model
		|---  Animal.java
		|---  Car.java
		|---  Cat.java
		|---  Dog.java
	+ \main\java\com\sujith\demo\controller
		|---  DemoController.java
		|---  DemoRestController.java
	+ \main\java\com\sujith\demo\config
		|---  Config.java
```
### Index
```pre
1. application.properties
2. model\Animal.java
3. model\Car.java
4. model\Cat.java
5. model\Dog.java
6. controller\DemoController.java
7. controller\DemoRestController.java
8. src\main\java\com\sujith\demo\DemoApplication.java
9. src\main\java\com\sujith\demo\config\Config.java
10. resources\templates\car.html
11. resources\templates\home.html
12. pom.xml

```

---

### 1. application.properties

#### application.properties

```properties



```

---

### 2. Animal.java

#### model\Animal.java

```java
package com.sujith.demo.model;

public interface Animal {
	public String getName();
}
```

---

### 3. Car.java

#### model\Car.java

```java
package com.sujith.demo.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Primary
@Component(value = "mynewcar")
@Data
@NoArgsConstructor
public class Car {

	private String company;
	private int price;
	private String color;
	
	public Car(String company, int price, String color) {
		super();
		this.company = company;
		this.price = price;
		this.color = color;
	}
}
```

---

### 4. Cat.java

#### model\Cat.java

```java
package com.sujith.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
	@Override
	public String getName() {
		return "Meow!! This is Cat!!";
	}
}
```

---

### 5. Dog.java

#### model\Dog.java

```java
package com.sujith.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	@Override
	public String getName() {
		return "Hey, this is Dog!";
	}
}
```

---

### 6. DemoController.java

#### controller\DemoController.java

```java
package com.sujith.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sujith.demo.model.Car;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/show")
	public ModelAndView showAView() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", "Pranisha");
		mv.setViewName("home");
		return mv;
	}

	@GetMapping("/car")
	public ModelAndView showCar() {  
		
		ModelAndView mv = new ModelAndView();
		Car c = new Car("scoda", 1000000, "black");
		mv.addObject("car", c);
		mv.setViewName("car");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/car2")
	public int showCar2(Model model) {  
		Car c = new Car("scoda", 1000000, "black");
		model.addAttribute("car", c);
		return 1;
	}
	
	@ResponseBody
	@GetMapping("/text")
	public Car showTest() {
		Car c = new Car("scoda", 1000000, "black");
		return c;
	}
	
	@ResponseBody
	@RequestMapping( path = "/car3")
	public List<Car> showTest2() {
		Car c = new Car("BNW", 23423424, "red");
		Car c2 = new Car("scoda", 1000000, "black");
		return List.of(c, c2);
	}
}
```

---

### 7. DemoRestController.java

#### controller\DemoRestController.java

```java
package com.sujith.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.sujith.demo.model.Car;

@RestController
@RequestMapping(name = "/api")
public class DemoRestController {

	private List<Car> cars = new ArrayList<>();
	
	@PostMapping
	public Car addCar(@RequestBody Car car) {
		cars.add(car);
		return car;
	}
	
	@GetMapping
	public List<Car> show() {
		return cars;
	}
	@GetMapping("/byId/{id}")
	public Car geyById(@PathVariable int id) {
		return cars.get(id);
	}
}
```

---

### 8. DemoApplication.java

#### src\main\java\com\sujith\demo\DemoApplication.java

```java
package com.sujith.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sujith.demo.model.Animal;
import com.sujith.demo.model.Car;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {
	
	@Autowired
	private Car car;
	
	@Autowired
	@Qualifier("dog")
	private Animal animal;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// String[] names = context.getBeanDefinitionNames();	
		// Arrays.stream(names).forEach(s -> System.out.println(s));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("...Testing...");
			
		System.out.println("Autowired   "+car);  
		System.out.println("Autowired   "+animal.getName());
		
	}	
```

---

### 9. Config.java

#### src\main\java\com\sujith\demo\config\Config.java

```java
package com.sujith.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.sujith.demo.model.Car;

@Configuration
public class Config {

	//@Primary
	@Bean(value = "pranisha")
	public Car getCar() {
		return new Car("maruthi",100,"red");
	}
}
```

---

### 10. car.html

#### resources\templates\car.html

```html
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Home Page</title>
<meta charset="UTF-8">
</head>

<body>

    <h1 th:text="${car}"></h1>
    <h1 th:text="${car.company}"></h1>
    <h1 th:text="${car.price}"></h1>
    <h1 th:text="${car.color}"></h1>
    
</body>
</html>
```

---

### 11. home.html

#### resources\templates\home.html

```html
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">

<head>
<title>Home Page</title>
<meta charset="UTF-8">
</head>

<body>
    <h1 th:text="${name}"></h1>
</body>

</html>
```

---

### 12. pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>demo</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	
	<dependencies>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-ui -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.11</version>
		</dependency>
	
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```