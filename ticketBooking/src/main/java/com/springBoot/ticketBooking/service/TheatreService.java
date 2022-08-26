package com.springBoot.ticketBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.jpaRespository.CinemaHallJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.CinemaScreenJpaRepository;
import com.springBoot.ticketBooking.model.CinemaHall;
import com.springBoot.ticketBooking.model.cinemaScreen;

@Component
public class TheatreService {
	@Autowired
	private CinemaHallJpaRepository cinemaHallJpaRepository;
	
	@Autowired
	private CinemaScreenJpaRepository cinemaScreenJpaRepository;

	public String addHall(CinemaHall hall) {
		
		try
		{
			cinemaHallJpaRepository.save(hall);
			return " Added Hall Successfully";
		}
		catch(Exception e)
		{
			return e.toString();
		}
		
	}

	public String addScreen(cinemaScreen screen) {
		try
		{
			screen.setScreenid("#"+screen.getScreename()+""+screen.getHall().getCinemaHallId());
			System.out.println(screen.getHall().getCinemaHallId());

			cinemaScreenJpaRepository.save(screen);
			return "Added Screen Successfully";
		}
		catch (Exception e) {
			return e.toString();
		}
	}
	
	

}
