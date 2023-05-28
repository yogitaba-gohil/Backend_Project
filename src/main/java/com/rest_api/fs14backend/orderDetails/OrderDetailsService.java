package com.rest_api.fs14backend.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository repository;

    public List<OrderDetails> saveOrderDetails(List<OrderDetails> orderDetails) {
        return repository.saveAll(orderDetails);
    }

    public List<UUID> getOrderDetailsIdsByUserId(UUID userId) {
        List<OrderDetails> orderDetails = repository.findOrderDetailsByUserId(userId);
        List<UUID> orderDetailsIds = new ArrayList<>();

        for (OrderDetails orderDetail : orderDetails) {
            orderDetailsIds.add(orderDetail.getId());
        }
        return orderDetailsIds;
    }

    public List<OrderDetails> getAllOrderDetailsByIds(List<UUID> orderDetailsIds) {
        return repository.findAllById(orderDetailsIds);
    }
}