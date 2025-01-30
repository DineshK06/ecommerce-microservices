package com.ecommerce.payment.service;

import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.repository.PaymentRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void processOrder(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            Long orderId = jsonNode.get("orderId").asLong();

            System.out.println("Processing Payment for Order ID: " + orderId);

            Payment payment = Payment.builder()
                    .orderId(orderId)
                    .amount(100.0)  // Mocked Payment Amount
                    .status("SUCCESS")
                    .createdAt(LocalDateTime.now())
                    .build();

            paymentRepository.save(payment);
            System.out.println("Payment Successful for Order ID: " + message);
        } catch (Exception e) {
            System.err.println("Error processing order event: " + e.getMessage());
        }
    }
}
