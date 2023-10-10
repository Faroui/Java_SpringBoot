package com.farouishop.productService.services;


import com.farouishop.productService.dtos.ProductRequest;
import com.farouishop.productService.dtos.ProductResponse;
import com.farouishop.productService.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductRequest productRequest);
    public ProductResponse getProductsById(String id) throws ProductNotFoundException;
    public List<ProductResponse>  getProducts();
}
