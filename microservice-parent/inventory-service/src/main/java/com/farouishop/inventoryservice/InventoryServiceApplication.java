package com.farouishop.inventoryservice;

import com.farouishop.inventoryservice.model.Inventory;
import com.farouishop.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {


	public static void main(String[] args) {

		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory=Inventory.builder()
					.skuCode("Dell_Latitude")
					.quantity(100)
					.build();
			Inventory inventory1= Inventory.builder()
					.skuCode("Sumsung_A01")
					.quantity(90)
					.build();
			inventoryRepository.save(inventory);
 			inventoryRepository.save(inventory1);
		};
	}

}
