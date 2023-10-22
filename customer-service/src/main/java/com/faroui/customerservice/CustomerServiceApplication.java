package com.faroui.customerservice;

import com.faroui.customerservice.model.Customer;
import com.faroui.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args ->{
				customerRepository.save(new Customer(null,"Ismail","ismail@gmail.com"));
				customerRepository.save(new Customer(null,"Hassan","hassan@gmail.com"));
				customerRepository.save(new Customer(null,"Abdellah","abdellah@gmail.com"));
				customerRepository.findAll().forEach(c->{
					System.out.println(c.toString());
				});
		};
	}

}
