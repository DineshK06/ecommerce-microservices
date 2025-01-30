package com.ecommerce.order.service;

import com.ecommerce.order.entity.Order;
import com.ecommerce.order.kafka.OrderEventProducer;
import com.ecommerce.order.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    public OrderService(OrderRepository orderRepository, OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.orderEventProducer = orderEventProducer;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order placeOrder(Long productId, Integer quantity) throws JsonProcessingException {
        Order order = Order.builder()
                .productId(productId)
                .quantity(quantity)
                .status("PLACED")
                .createdAt(LocalDateTime.now())
                .build();
        orderRepository.save(order);

        orderEventProducer.sendOrderEvent(order.getId());

        return order;
    }

    public Order updateOrderStatus(Long id, String status) {
        Order existingOrder = getOrderById(id);
        existingOrder.setStatus(status);
        return orderRepository.save(existingOrder);
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
