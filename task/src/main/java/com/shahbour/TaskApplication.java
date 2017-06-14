package com.shahbour;

import com.shahbour.client.ResourceClient;
import com.shahbour.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.List;

@EnableDiscoveryClient(autoRegister = false)
@EnableFeignClients
@SpringBootApplication
@EnableOAuth2Client
@Slf4j
public class TaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Autowired
	ResourceClient resourceClient;

	@Override
	public void run(String... strings) throws Exception {
		List<Customer> customers = resourceClient.getCustomers();

		log.info("found {} customer",customers.size());
	}
}
