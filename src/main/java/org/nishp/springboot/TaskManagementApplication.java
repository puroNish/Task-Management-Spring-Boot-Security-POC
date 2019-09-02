package org.nishp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.nishp.springboot")
public class TaskManagementApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
