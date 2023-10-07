package com.farouishop.farouishop.services;

import com.farouishop.farouishop.dtos.ProductRequest;
import com.farouishop.farouishop.dtos.ProductResponse;
import com.farouishop.farouishop.entities.Product;
import com.farouishop.farouishop.mappers.ProductMapper;
import com.farouishop.farouishop.mappers.ProductMapperImpl;
import com.farouishop.farouishop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void addProduct(ProductRequest productRequest) {
        Product product=productMapper.fromProductRequestToProduct(productRequest);
        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }
    @Override
    public ProductResponse getProductsById(Long id) {
        return productMapper.fromProductToProductResponse(productRepository.findById(id).
                orElseThrow());
    }
    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products=productRepository.findAll();
        return products.stream()
                .map(productMapper::fromProductToProductResponse)
                .collect(Collectors.toList());
    }
}
