package com.moviebooking.payment.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moviebooking.payment.config.RabbitmqConfig;
import com.moviebooking.payment.model.PaymentStatus;
import com.moviebooking.payment.model.PriceModel;


@RestController
public class PaymentPublisher {

    @Autowired
    private RabbitTemplate template;
    
    RestTemplate restTemplate = new RestTemplate();
    
//    @Autowired
//    PaymentJpaRepository paymentJpaRepository;

    @PostMapping("/paymentStatusMessage")
    public String bookOrder(@RequestBody PriceModel price) {
    	
    	System.out.println("hi");

        PaymentStatus paymentStatus = new PaymentStatus();
        paymentStatus.setPaymentStatus(price.getBookingId());
        
        template.convertAndSend(RabbitmqConfig.EXCHANGE, RabbitmqConfig.ROUTING_KEY, paymentStatus);
        
//        ResponseEntity<String> payment=restTemplate.getForEntity("http://localhost:9002/isPaymentDone", String.class);
        
        
        if(Integer.parseInt(price.getAmount())==Integer.parseInt(price.getTotalPrice()))
        {
        	
        	System.out.println("sabari");
        	
        	ResponseEntity<String> payment=restTemplate.getForEntity("http://localhost:9002/isPaymentDone", String.class);
        	ResponseEntity<String> success=restTemplate.postForEntity("http://localhost:9001/PaymentSuccess",payment.getBody(),String.class);
        	
            return "PaymentSuccess";
        }
        else
        {
        	
            return "Payment Failure";
        }
        
        
    }
}
