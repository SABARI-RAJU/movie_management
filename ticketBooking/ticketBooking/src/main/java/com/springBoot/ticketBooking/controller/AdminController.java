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

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class AdminController {
	
	@Autowired
	private AdminMoviesService adminMoviesService;
	
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
		cinemaHallJpaRepository.save(hall);
		return " Added Hall Successfully";
		
		
		
	}
	
	@PostMapping(value = "/addScreen")
	public String adminTheatreAdd(HttpServletRequest req, HttpServletResponse res,@RequestBody cinemaScreen screen)
	{
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
	
	@PostMapping(value = "/adminReserve")
	public String reserveMovie(HttpServletRequest req, HttpServletResponse res,@RequestBody Booking register)
	{
		
		bookingJpaRepository.reserveSeat(register.getShow().getShowId(),register.getSeatno());
		return "Seat Reserved Successfully";
		
		
	}

	
	@PostMapping(value = "/createShow")
	public String adminCreateShow(HttpServletRequest req, HttpServletResponse res,@RequestBody Shows show)
	{
		System.out.println(show.getScreen().getScreenid().toString());
		show.setShowId("#"+show.getShowDate()+""+show.getShowType()+""+show.getScreen().getScreenid());
		ScreenSeat seat=new ScreenSeat();
		int row=cinemaScreenJpaRepository.findByscreenid(show.getScreen().getScreenid()).getRowdetails();
		int column=cinemaScreenJpaRepository.findByscreenid(show.getScreen().getScreenid()).getRowdetails();
		System.out.println(row);
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i=0;i<row;i++)
		{
			for(int j=1;j<=column;j++)
			{
				seat.setSeatId(show.getShowId()+""+alphabet[i]+""+j);
				seat.setSeatNumber(alphabet[i]+""+j);
				seat.setStatus(false);
				seat.setReserved(false);
				seat.setPrice(show.getPrice());
				seat.setScreenid(show.getScreen().getScreenid());
				seat.setShowDate(show.getShowDate());
				seat.setShowid(show.getShowId());
				seatJpaRepository.save(seat);
				
			}
			
		}
		showJpaRepository.save(show);
		
		return "Show created Successfully!!";
	}

}
