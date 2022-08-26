package com.springBoot.ticketBooking.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.jpaRespository.BookingJpaRepository;
import com.springBoot.ticketBooking.model.Booking;

@Component
public class BookingService {
	@Autowired
	private BookingJpaRepository bookingJpaRepository;

	public String movieBooking(Booking register) {
		try
		{
			Random random = new Random();
			List<Object> checkReserved=bookingJpaRepository.checkIsReserved(register.getShow().getShowId(),register.getSeatno());
			if(checkReserved.contains(true))
			{
				return "Already reserved....... Choose another seats";
			}
			else
			{
				register.setBookingid(register.getShow().getShowId()+""+register.getUser().getUserid()+""+random.nextInt(100,900));
				System.out.println(register.toString());
				bookingJpaRepository.save(register);
				
				
				return "Seats booked Successfully!!!!!!!!";
			}		
		}
		catch(Exception e)
		{
			return e.toString();
		}
	}

	public String cancelBooking(Booking book) {
		try
		{
			bookingJpaRepository.cancelTicket(book.getBookingid());
			bookingJpaRepository.updateBookingStatus(book.getBookingid());
			
			return "Cancelled Seat Sucessfully.....";
		}
		catch(Exception e)
		{
			return e.toString();
		}
	}

	public String adminReserve(Booking register) {
		try
		{
			bookingJpaRepository.reserveSeat(register.getShow().getShowId(),register.getSeatno());
			return "Seat Reserved Successfully";
		}
		catch(Exception e)
		{
			return e.toString();
		}
		
	}
	

}
