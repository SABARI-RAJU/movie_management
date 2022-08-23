package com.moviebooking.payment.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.payment.config.RabbitmqConfig;
import com.moviebooking.payment.model.PaymentStatus;

@Component
@RestController
public class PaymentConsumer {
	
	String message;
	
    @RabbitListener(queues = RabbitmqConfig.QUEUE)
    public void consumeMessageFromQueue(PaymentStatus paymentStatus) {
    	this.message=paymentStatus.getPaymentStatus();        
    }
    
    @GetMapping("/isPaymentDone")
    public String payment()
    {
    	return this.message;
    }
    
}
