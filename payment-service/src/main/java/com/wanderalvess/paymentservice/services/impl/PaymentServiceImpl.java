package com.wanderalvess.paymentservice.services.impl;

import com.wanderalvess.paymentservice.model.Payment;
import com.wanderalvess.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    public void sendPayment(Payment payment) throws InterruptedException {
        System.out.println("Recebi o pagamento: " + payment);
        Thread.sleep(1000);
        System.out.println("Enviando Pagamento... " + payment);
        kafkaTemplate.send("payment-topic", payment);

    }

    public KafkaTemplate<String, Serializable> getKafkaTemplate() {
        return kafkaTemplate;
    }

    public void setKafkaTemplate(KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
