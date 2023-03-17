package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        return null;
    }

    @Override
    public void cancelOrDeleteOrder(Long Id) {

    }
}
