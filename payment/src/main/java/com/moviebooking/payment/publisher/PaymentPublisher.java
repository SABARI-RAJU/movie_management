package com.moviebooking.payment.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.payment.config.RabbitmqConfig;
import com.moviebooking.payment.model.PaymentStatus;
import com.moviebooking.payment.model.PriceModel;


@RestController
public class PaymentPublisher {

    @Autowired
    private RabbitTemplate template;
    
//    @Autowired
//    PaymentJpaRepository paymentJpaRepository;

    @PostMapping("/paymentStatusMessage")
    public String bookOrder(@RequestBody PriceModel price) {

        PaymentStatus paymentStatus = new PaymentStatus();
        if(price.getAmount()==price.getTotalPrice())
        {
        	paymentStatus.setPaymentStatus("success");
            template.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY, paymentStatus);
            return "Success";
        }
        else
        {
        	paymentStatus.setPaymentStatus("Fail");
            template.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY, paymentStatus);
            return "Fail";
        }
        
    }
}
