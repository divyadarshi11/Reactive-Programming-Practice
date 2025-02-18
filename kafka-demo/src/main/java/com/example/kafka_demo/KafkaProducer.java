package com.example.kafka_demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        // Sending message and handling response using CompletableFuture
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        
        future.thenAccept(result -> {
            // Success callback
            System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }).exceptionally(ex -> {
            // Failure callback
            System.err.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            return null;
        });
    }
}
