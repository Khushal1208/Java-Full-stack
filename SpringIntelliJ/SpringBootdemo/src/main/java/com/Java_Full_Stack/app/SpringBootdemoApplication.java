package com.Java_Full_Stack.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootdemoApplication {

	public static void main(String[] args) {
//		 SpringApplication.run(SpringBootdemoApplication.class, args);
//		Alien obj = new Alien(); i dont want to create obj by myself i want spring to do it.
//		i need to create an way to have application context.

		ApplicationContext context = SpringApplication.run(SpringBootdemoApplication.class, args);
//		Bydefault Spring does not create obj of all the classes
//	    we have to say that created obj of that in container using @Component
//	    And if that class is also depend on other class then use @Autowired to link that and gets obj of that class from container.
		Alien obj = context.getBean(Alien.class);
		obj.code();
	}
}
