package com.rest_api.fs14backend.orders;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://127.0.0.1:5173", "https://front-end-project-liart.vercel.app"}, maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService service) {
        this.orderService = service;
    }
    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }
    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable UUID id) {
        orderService.deleteById(id);
    }
    @PutMapping("/orders/{id}")
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable UUID userId) {
        return orderService.getOrdersByUserId(userId);
    }
}
