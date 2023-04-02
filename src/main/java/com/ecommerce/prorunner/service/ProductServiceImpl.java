package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProductEntity;
import com.ecommerce.prorunner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity addProduct(ProductEntity productEntity) {
        try {
            productEntity.setImage(Base64.getEncoder().encodeToString(productEntity.getFile().getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> listOfProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> listOfProductsByIds(List<Long> productIds) {
        return productRepository.listOfProductsByIds(productIds);
    }

    @Override
    public List<ProductEntity> getProductsByCategoryAndSubCategory(String category, String categoryType) {
        if(categoryType == null)
            return productRepository.getProductsByCategory(category);
        else
            return productRepository.getProductsByCategoryAndSubCategory(category, categoryType);
    }
}
