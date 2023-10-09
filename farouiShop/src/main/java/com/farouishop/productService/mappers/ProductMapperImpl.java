package com.farouishop.productService.mappers;

import com.farouishop.productService.dtos.ProductRequest;
import com.farouishop.productService.dtos.ProductResponse;
import com.farouishop.productService.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductRequest fromProductToProductRequest(Product product)  {
        ProductRequest productRequest=new ProductRequest();
        BeanUtils.copyProperties(product,productRequest);
        return productRequest;
    }
    @Override
    public ProductResponse fromProductToProductResponse(Product product) {
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }
    @Override
    public Product fromProductRequestToProduct(ProductRequest productRequest) {
        Product product =new Product();
        BeanUtils.copyProperties(productRequest,product);
        return product;
    }

}
