package com.farouishop.farouishop.mappers;

import com.farouishop.farouishop.dtos.ProductRequest;
import com.farouishop.farouishop.dtos.ProductResponse;
import com.farouishop.farouishop.entities.Product;
import com.farouishop.farouishop.services.ProductService;
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
