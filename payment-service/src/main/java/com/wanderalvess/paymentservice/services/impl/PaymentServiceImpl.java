package com.wanderalvess.paymentservice.services.impl;

import com.wanderalvess.paymentservice.model.Payment;
import com.wanderalvess.paymentservice.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void sendPayment(Payment payment) {
        System.out.println("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento: " + payment);
    }

}
