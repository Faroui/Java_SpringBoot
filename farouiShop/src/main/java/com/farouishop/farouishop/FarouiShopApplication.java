package com.farouishop.farouishop;

import com.farouishop.farouishop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
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
