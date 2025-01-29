package com.ecommerce.product.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    @KafkaListener(topics = "order-events", groupId = "product-service-group-v2")
    public void consumeOrderEvent(String message) {
        System.out.println("Received Order Event: " + message);
    }
}
