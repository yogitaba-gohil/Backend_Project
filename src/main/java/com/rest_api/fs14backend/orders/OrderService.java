package com.rest_api.fs14backend.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order) {
        return repository.save(order);
    }
    public List<Order> findAll() {
        return repository.findAll();
    }

    public List<Order> getOrdersByUserId(UUID userId) {
        return repository.findOrdersByUserId(userId);
    }
}