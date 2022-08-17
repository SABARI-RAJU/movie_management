package com.springBoot.ticketBooking.jpaRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.springBoot.ticketBooking.model.Booking;
import com.springBoot.ticketBooking.model.CinemaHall;


@Component
public interface CinemaHallJpaRepository extends JpaRepository<CinemaHall,String> {
	
	

}
