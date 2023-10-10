package com.farouishop.productService.mappers;

import com.farouishop.productService.dtos.ProductRequest;
import com.farouishop.productService.dtos.ProductResponse;
import com.farouishop.productService.entities.Product;

public interface ProductMapper {
    public ProductRequest fromProductToProductRequest(Product product);
    public ProductResponse fromProductToProductResponse(Product product);
    public Product fromProductRequestToProduct(ProductRequest productRequest);
}
