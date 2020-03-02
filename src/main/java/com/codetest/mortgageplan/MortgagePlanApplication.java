package com.codetest.mortgageplan;

import controller.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"service", "view", "controller", "com.codetest.mortgageplan"})
@EnableJpaRepositories("dao")
@EntityScan("model")
public class MortgagePlanApplication implements CommandLineRunner {

	@Autowired
	AppConfig appConfig;
	@Autowired
	CustomerController customerController;

	public static void main(String[] args) {
		SpringApplication.run(MortgagePlanApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(appConfig.getDb_url());
		customerController.runApp();
	}
}
