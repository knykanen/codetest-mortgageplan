package com.codetest.mortgageplan;

import controller.CustomerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MortgagePlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgagePlanApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		CustomerController customerController = new CustomerController();
		customerController.runApp();
	}
}
