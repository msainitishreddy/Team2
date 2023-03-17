package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.entity.ProductEntity;

public interface ProRunnerUserService {
    ProRunnerUserEntity createOrder(ProRunnerUserEntity proRunnerUserEntity);
    void deleteProduct(Long Id);
}
