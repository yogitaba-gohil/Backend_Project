package com.rest_api.fs14backend.orderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, UUID> {
    List<OrderDetails> findOrderDetailsByUserId(UUID orderId);
}