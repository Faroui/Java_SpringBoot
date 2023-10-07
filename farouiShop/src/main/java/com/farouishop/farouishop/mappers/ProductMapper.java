package com.farouishop.farouishop.mappers;

import com.farouishop.farouishop.dtos.ProductRequest;
import com.farouishop.farouishop.dtos.ProductResponse;
import com.farouishop.farouishop.entities.Product;

public interface ProductMapper {
    public ProductRequest fromProductToProductRequest(Product product);
    public ProductResponse fromProductToProductResponse(Product product);
    public Product fromProductRequestToProduct(ProductRequest productRequest);
}
