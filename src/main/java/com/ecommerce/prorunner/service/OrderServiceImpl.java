package com.ecommerce.prorunner.service;

import com.ecommerce.prorunner.entity.OrderEntity;
import com.ecommerce.prorunner.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    @Override
    public void cancelOrDeleteOrder(Long Id) {

    }
}
