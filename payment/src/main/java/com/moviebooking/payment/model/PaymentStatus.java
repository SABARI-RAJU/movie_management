package com.moviebooking.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatus {
	private String paymentStatus;
	
	

	public PaymentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentStatus(String paymentStatus) {
		super();
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	

}
