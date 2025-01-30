package com.ecommerce.order.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderEventProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaBootstrapServers;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderEvent(Long orderId) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(Map.of("orderId", orderId));
        System.out.println("Sending Order Event: " + message);
        kafkaTemplate.send("order-events", message);
    }

    @PostConstruct
    public void logKafkaConfig() {
        System.out.println("🔥 Kafka Config Loaded: " + kafkaBootstrapServers);
    }
}
