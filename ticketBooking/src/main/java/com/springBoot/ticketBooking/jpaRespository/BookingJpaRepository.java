package com.springBoot.ticketBooking.jpaRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.springBoot.ticketBooking.model.Booking;


@Component
public interface BookingJpaRepository extends JpaRepository<Booking,Long> {
	
	

}
