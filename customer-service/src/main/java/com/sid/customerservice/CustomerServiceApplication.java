package com.sid.customerservice;

import com.sid.customerservice.entities.Customer;
import com.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"aymane","aymane@live.fr"));
			customerRepository.save(new Customer(null,"omar","omar@live.fr"));
			customerRepository.save(new Customer(null,"saad","saad@live.fr"));
			customerRepository.save(new Customer(null,"amine","amine@live.fr"));
			customerRepository.findAll().forEach( c -> {
				System.out.println(c.toString());
			});
		};
	}

}
