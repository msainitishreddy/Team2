package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity createOrder(OrderEntity orderEntity);

    void cancelOrDeleteOrder(Long Id);
}
