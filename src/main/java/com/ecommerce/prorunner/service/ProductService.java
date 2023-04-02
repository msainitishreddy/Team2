package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    ProductEntity addProduct(ProductEntity productEntity);

    List<ProductEntity> listOfProducts();

    List<ProductEntity> listOfProductsByIds(List<Long> productIds);

    List<ProductEntity> getProductsByCategoryAndSubCategory(String category, String categoryType);
}
