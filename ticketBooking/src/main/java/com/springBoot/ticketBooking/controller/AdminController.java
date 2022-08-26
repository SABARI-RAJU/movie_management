package com.springBoot.ticketBooking.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.ticketBooking.jpaRespository.BookingJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.CinemaHallJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.CinemaScreenJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.SeatJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.ShowJpaRepository;
import com.springBoot.ticketBooking.model.Booking;
import com.springBoot.ticketBooking.model.CinemaHall;
import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.ScreenSeat;
import com.springBoot.ticketBooking.model.Shows;
import com.springBoot.ticketBooking.model.cinemaScreen;
import com.springBoot.ticketBooking.service.AdminMoviesService;
import com.springBoot.ticketBooking.service.BookingService;
import com.springBoot.ticketBooking.service.TheatreService;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class AdminController {
	
	@Autowired
	private AdminMoviesService adminMoviesService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private TheatreService theatreService;
	
	@Autowired
	private CinemaHallJpaRepository cinemaHallJpaRepository;
	
	@Autowired
	private CinemaScreenJpaRepository cinemaScreenJpaRepository;
	
	@Autowired
	private SeatJpaRepository seatJpaRepository;
	
	@Autowired
	private ShowJpaRepository showJpaRepository;
	
	@Autowired
	private BookingJpaRepository bookingJpaRepository;
	
	@PostMapping(value = "/addMovies")
	public String addMovies(HttpServletRequest req, HttpServletResponse res,@RequestBody Movielist movies) {

		Random random = new Random();
		movies.setMovieid("#"+movies.getTitle().substring(0,3)+random.nextInt(100,900));
		adminMoviesService.addmoviesService(movies);
		return "Movie Added Successfully!!!!";
		
	}
	@PostMapping(value = "/updateMovies")
	public String updateMovies(HttpServletRequest req, HttpServletResponse res,@RequestBody Movielist movies) {
		System.out.println("update movies");
		adminMoviesService.updatemoviesService(movies);
		return "Movie Updated Successfully!!!";
		
	}
	
	@PostMapping(value = "/addHall")
	public String adminHallAdd(HttpServletRequest req, HttpServletResponse res,@RequestBody CinemaHall hall)
	{
		hall.setCinemaHallId("#"+hall.getName());
		return theatreService.addHall(hall);
		
		
		
	}
	
	@PostMapping(value = "/addScreen")
	public String adminTheatreAdd(HttpServletRequest req, HttpServletResponse res,@RequestBody cinemaScreen screen)
	{
		return theatreService.addScreen(screen);
		
		
	} 
	
	@PostMapping(value = "/adminReserve")
	public String reserveMovie(HttpServletRequest req, HttpServletResponse res,@RequestBody Booking register)
	{
		return bookingService.adminReserve(register);
	}

	
	@PostMapping(value = "/createShow")
	public String adminCreateShow(HttpServletRequest req, HttpServletResponse res,@RequestBody Shows show)
	{
		return adminMoviesService.createShow(show);
		
	}

}
