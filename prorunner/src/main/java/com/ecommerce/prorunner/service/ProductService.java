package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity addProduct(ProductEntity productEntity);

    List<ProductEntity> listOfProducts();
    void deleteProduct(Long Id);
}
