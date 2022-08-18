package com.springBoot.ticketBooking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.ticketBooking.jpaRespository.BookingJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.CinemaHallJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.CinemaScreenJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.MovieJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.SeatJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.ShowJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.UserJpaRepository;
import com.springBoot.ticketBooking.model.Booking;
import com.springBoot.ticketBooking.model.CinemaHall;
import com.springBoot.ticketBooking.model.FilterResponse;
import com.springBoot.ticketBooking.model.JwtRequest;
import com.springBoot.ticketBooking.model.JwtResponse;
import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.ScreenSeat;
import com.springBoot.ticketBooking.model.ShowFilter;
import com.springBoot.ticketBooking.model.Shows;
import com.springBoot.ticketBooking.model.UserModel;
import com.springBoot.ticketBooking.model.cinemaScreen;
import com.springBoot.ticketBooking.service.AdminMoviesService;
import com.springBoot.ticketBooking.service.UserService;
import com.springBoot.ticketBooking.utility.JWTUtility;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class MainController {
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private BookingJpaRepository bookingJpaRepository;
	
	@Autowired
	private MovieJpaRepository movieJpaRepository;
	
	@Autowired
	private CinemaHallJpaRepository cinemaHallJpaRepository;
	
	@Autowired
	private ShowJpaRepository showJpaRepository;
	
	@Autowired
	private CinemaScreenJpaRepository cinemaScreenJpaRepository;
	
	@Autowired
	private SeatJpaRepository seatJpaRepository;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminMoviesService adminMoviesService;

	@PostMapping(value = "/addMovies")
	public void addMovies(HttpServletRequest req, HttpServletResponse res,@RequestBody Movielist movies) {

		Random random = new Random();
		movies.setMovieid("#"+movies.getTitle().substring(0,3)+random.nextInt(100,900));
		adminMoviesService.addmoviesService(movies);
		
	}
	@PostMapping(value = "/updateMovies")
	public void updateMovies(HttpServletRequest req, HttpServletResponse res,@RequestBody Movielist movies) {
		System.out.println("update movies");
		adminMoviesService.updatemoviesService(movies);
		
	}
	
	@PostMapping(value = "/registerMovies")
	public void registerMovies(HttpServletRequest req, HttpServletResponse res,@RequestBody Booking register)
	{
		register.setBookingid(register.getShow().getShowId()+""+register.getUser().getUserid());
		System.out.println(register.toString());
		bookingJpaRepository.bookseat(register.getShow().getShowId(),register.getSeatno());
		bookingJpaRepository.save(register);
		
		
	}
	
	@PostMapping(value = "/addHall")
	public void adminTheatreAdd(HttpServletRequest req, HttpServletResponse res,@RequestBody CinemaHall hall)
	{
		System.out.println(hall.getScreen());
		cinemaHallJpaRepository.save(hall);
		
		
	}
	
	@PostMapping(value = "/addScreen")
	public void adminTheatreAdd(HttpServletRequest req, HttpServletResponse res,@RequestBody cinemaScreen screen)
	{
		System.out.println(screen.getHall().getCinemaHallId());

		cinemaScreenJpaRepository.save(screen);
		
		
	}
	@PostMapping(value = "/createShow")
	public void adminCreateShow(HttpServletRequest req, HttpServletResponse res,@RequestBody Shows show)
	{
		System.out.println(show.getScreen().getScreenid().toString());
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
		
		
	}
	
	
	
	@PostMapping(value = "/showFilter")
	public List<FilterResponse> adminCreateShow(HttpServletRequest req, HttpServletResponse res,@RequestBody ShowFilter filter)
	{
		return showJpaRepository.findmovies(filter.getShowtype(),filter.getShowdate(),filter.getMovietype(),filter.getScreenid(),filter.getName(),filter.getCity());
		
		
	}
	
	@GetMapping(value = "/movieList")
	public List<Movielist> getmovies(HttpServletRequest req, HttpServletResponse res) {
		
		return movieJpaRepository.findAll();
	}

	@PostMapping(value = "/signUp")
	public void load(@RequestBody UserModel user) {
		try {
			System.out.println(user.getUsername());
			user.setUserid(user.getEmail()+""+user.getUsername());
			userJpaRepository.save(user);
			System.out.println("records inserted into database");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@PostMapping("/login")
	public JwtResponse authenticate(HttpServletRequest req, HttpServletResponse res, @RequestBody JwtRequest jwtRequest)
			throws Exception {

		try {
			System.out.println("kd billa");
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUseremail(), jwtRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUseremail());
		System.out.println(userDetails.getAuthorities());
		System.out.println(userDetails.getUsername());

		final String token = jwtUtility.generateToken(userDetails);
		HttpSession session = req.getSession();
		System.out.println();
		session.setAttribute("token", token);
		System.out.println(token);

		return new JwtResponse(token);
	}

}
