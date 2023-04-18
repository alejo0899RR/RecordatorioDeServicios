package com.eis.alertasApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.eis")
@ComponentScan(basePackages = "com.eis")
public class AlertasAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AlertasAppApplication.class, args);
	}
}

