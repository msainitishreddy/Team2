package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.OrderEntity;

public interface OrderService {
    OrderEntity createOrder(OrderEntity orderEntity);
    void cancelOrDeleteOrder(Long Id);
}
