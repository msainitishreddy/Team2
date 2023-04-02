package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.entity.ProductEntity;

import java.util.List;

public interface ProRunnerUserService {
    ProRunnerUserEntity createUser(ProRunnerUserEntity proRunnerUserEntity);

    ProRunnerUserEntity findProRunnerUserByEmail(String email);
    void deleteProduct(Long Id);
    List<ProductEntity> addProductsToCartList(Long productId, String email);

    List<ProductEntity> removeProductFromCartList(Long productId, String email);

    List<ProductEntity> getCartListProducts(String email);

    List<ProductEntity> getCartListProductsByIds(String productIds);

    String placeOrder(String email);
}
