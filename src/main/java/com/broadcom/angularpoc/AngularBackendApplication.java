package com.broadcom.angularpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.broadcom.angularpoc.*")
public class AngularBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularBackendApplication.class, args);
	}

}
