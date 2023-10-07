package com.farouishop.farouishop.services;


import com.farouishop.farouishop.dtos.ProductRequest;
import com.farouishop.farouishop.dtos.ProductResponse;

import java.util.List;

public interface ProductService {
    public void addProduct(ProductRequest productRequest);
    public ProductResponse getProductsById(Long id);
    public List<ProductResponse>  getProducts();
}
