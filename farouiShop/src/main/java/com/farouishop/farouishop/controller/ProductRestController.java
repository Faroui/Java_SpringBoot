package com.farouishop.farouishop.controller;
import com.farouishop.farouishop.dtos.ProductRequest;
import com.farouishop.farouishop.dtos.ProductResponse;
import com.farouishop.farouishop.exceptions.ProductNotFoundException;
import com.farouishop.farouishop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){

        productService.addProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> products(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getById(@PathVariable String id) throws ProductNotFoundException {
        return productService.getProductsById(id);
    }
}
