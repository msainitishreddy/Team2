package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductEntity addProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> listOfProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long Id) {

    }
}
