package com.shahbour;

import com.shahbour.domain.Customer;
import com.shahbour.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class ResourceServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServiceApplication.class, args);
	}

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... strings) throws Exception {
		customerRepository.save(new Customer(1,"Ali Shhabour"));
		customerRepository.save(new Customer(2,"Joesph"));
		customerRepository.save(new Customer(3,"Chadi"));
		customerRepository.save(new Customer(4,"Movses"));
		customerRepository.save(new Customer(5,"Hammoud"));
	}
}
