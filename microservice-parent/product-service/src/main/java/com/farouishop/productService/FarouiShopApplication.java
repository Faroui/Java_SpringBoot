package com.farouishop.productService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EnableMongoRepositories

public class FarouiShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(FarouiShopApplication.class, args);
	}
}
