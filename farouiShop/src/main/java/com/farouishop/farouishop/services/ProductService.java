package com.farouishop.farouishop.services;


import com.farouishop.farouishop.dtos.ProductRequest;
import com.farouishop.farouishop.dtos.ProductResponse;
import com.farouishop.farouishop.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductRequest productRequest);
    public ProductResponse getProductsById(String id) throws ProductNotFoundException;
    public List<ProductResponse>  getProducts();
}
