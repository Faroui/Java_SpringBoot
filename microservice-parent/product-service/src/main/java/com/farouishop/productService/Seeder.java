package com.farouishop.productService;

import com.farouishop.productService.entities.Product;
import com.farouishop.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Seeder implements CommandLineRunner {
    private final ProductRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.save(
                Product.builder()
                        .name("Apple")
                        .description("iphone 14 pro max")

                        .build()
        );
        System.out.println("saved");
    }
}
