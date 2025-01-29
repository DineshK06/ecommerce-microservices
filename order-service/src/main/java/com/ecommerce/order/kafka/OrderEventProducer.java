package com.ecommerce.order.kafka;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaBootstrapServers;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(String message) {
        System.out.println("Sending Order Event: " + message);
        kafkaTemplate.send("order-events", message);
    }

    @PostConstruct
    public void logKafkaConfig() {
        System.out.println("🔥 Kafka Config Loaded: " + kafkaBootstrapServers);
    }
}
