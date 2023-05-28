package com.rest_api.fs14backend.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://127.0.0.1:5173", maxAge = 3600)
@RestController
@RequestMapping("api/v1/order-details")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService service;



    @PostMapping("/all-order-details")
    public List<OrderDetails> saveOrderDetails(@RequestBody List<OrderDetails> orderDetails) {
        return service.saveOrderDetails(orderDetails);
    }

    @GetMapping("/{userId}")
    public List<UUID> getOrderDetailsByUserId(@PathVariable UUID userId) {
        return service.getOrderDetailsIdsByUserId(userId);
    }

    @GetMapping("/all-order-details")
    public List<OrderDetails> getAllOrderDetailsByIds(@RequestBody List<UUID> orderDetailsIds) {
        return service.getAllOrderDetailsByIds(orderDetailsIds);
    }

}