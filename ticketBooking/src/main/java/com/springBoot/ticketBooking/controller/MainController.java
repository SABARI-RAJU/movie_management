package com.springBoot.ticketBooking.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
import com.springBoot.ticketBooking.service.BookingService;
import com.springBoot.ticketBooking.service.UserService;
import com.springBoot.ticketBooking.utility.JWTUtility;

import io.swagger.models.Response;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class MainController {
	
	@Autowired
	private AdminMoviesService adminMoviesService;
	
	@Autowired
	private BookingService bookingService;


	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private BookingJpaRepository bookingJpaRepository;


	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	@PostMapping(value = "/registerMovies")
	public String registerMovies(HttpServletRequest req, HttpServletResponse res,@RequestBody Booking register)
	{
		return bookingService.movieBooking(register);
		
	}
	
	
	@PostMapping(value = "/cancelTicket")
	public String cancelTicket(HttpServletRequest req, HttpServletResponse res,@RequestBody Booking book)
	{
		return bookingService.cancelBooking(book);
		
	}
	
	
	
	@PostMapping(value = "/showFilter")
	public List<FilterResponse> adminCreateShow(HttpServletRequest req, HttpServletResponse res,@RequestBody ShowFilter filter)
	{
		return adminMoviesService.movieFilter(filter);
		
		
	}
	
	@GetMapping(value = "/allMovies")
	public List<Movielist> getmovies(HttpServletRequest req, HttpServletResponse res) {
		
		return adminMoviesService.allMovies();		
		
	}

	@PostMapping(value = "/signUp")
	public String load(@RequestBody UserModel user) {
		
		try {
			System.out.println(user.getUsername());
			SimpleDateFormat dnt = new SimpleDateFormat("yy/MM/dd");
	        Date date = new Date();
	        user.setCreateddate(dnt.format(date).toString());
			user.setUserid(user.getEmail()+""+user.getUsername());
			userJpaRepository.save(user);
			System.out.println("records inserted into database");
			return "Registered Susscessfully";
		} catch (Exception e) {
			System.out.println(e);
			return "Error in registering...";
		}

	}

	@PostMapping("/login")
	public JwtResponse authenticate(HttpServletRequest req, HttpServletResponse res, @RequestBody JwtRequest jwtRequest)
			throws Exception {

		try {
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
	
	
	
	@PostMapping("/payment/{amount}")
	public ResponseEntity<String> rabbitmq(HttpServletRequest req, HttpServletResponse res, @RequestBody Booking register,@PathVariable int amount)
	{
			List<Object> price=bookingJpaRepository.getPrice(register.getShow().getShowId(),register.getSeatno());
			
			int totalPrice=0;
			for(Object i:price)
			{
				totalPrice+=(Integer)i;
			}
			Map<String, String> map = new HashMap<>();
			map.put("totalPrice",Integer.toString(totalPrice));
			map.put("amount", Integer.toString(amount));
			map.put("bookingId", register.getBookingid());
				
			ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:9002/paymentStatusMessage", map, String.class);
			
			
			
//			ResponseEntity<String> payment=restTemplate.getForEntity("http://localhost:9002/isPaymentDone", String.class);
			
//			if(payment.getBody().equals("success"))
//			{
//				register.setBookingid(register.getBookingid());
//				bookingJpaRepository.bookseat(register.getShow().getShowId(),register.getSeatno(),register.getBookingid());
//				bookingJpaRepository.setPaymentStatus(register.getBookingid());
//				return payment;
//			}
//			else
//			{
//				return payment;
//			}
			
			return result;
			
	}
	
	@PostMapping("/PaymentSuccess")
	public String paymentSuccess(HttpServletRequest request,HttpServletResponse response, @RequestBody String bookingId)
	{
		Booking register=bookingJpaRepository.findByBookingid(bookingId);
		register.setBookingid(register.getBookingid());
		bookingJpaRepository.bookseat(register.getShow().getShowId(),register.getSeatno(),register.getBookingid());
		bookingJpaRepository.setPaymentStatus(register.getBookingid());
		
		return "Payment Successfull";
		
	}

}
