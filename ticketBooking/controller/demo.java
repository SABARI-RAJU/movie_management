package com.springBoot.ticketBooking.controller;

import java.util.List;

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

import com.springBoot.ticketBooking.jpaRespository.MovieJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.UserJpaRepository;
import com.springBoot.ticketBooking.model.JwtRequest;
import com.springBoot.ticketBooking.model.JwtResponse;
import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.UserModel;
import com.springBoot.ticketBooking.service.UserService;
import com.springBoot.ticketBooking.utility.JWTUtility;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class demo {
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private MovieJpaRepository movieJpaRepository;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/admin")
	public String getadmin(HttpServletRequest req, HttpServletResponse res) {

		HttpSession session = req.getSession();
		System.out.println();
		System.out.println(session.getAttribute("token"));
		return "Admin   " + session.getAttribute("token");
	}
	
	@GetMapping(value = "/main")
	public List<Movielist> getmovies(HttpServletRequest req, HttpServletResponse res) {
		
		return movieJpaRepository.findAll();
	}

	@GetMapping(value = "/user")
	public String getuser() {

		return "user";
	}

	@PostMapping(value = "/signUp")
	public void load(@RequestBody UserModel user) {
		try {
			System.out.println(user.getUsername());
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
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
		System.out.println(userDetails.getAuthorities());

		final String token = jwtUtility.generateToken(userDetails);
		HttpSession session = req.getSession();
		System.out.println();
		session.setAttribute("token", token);
		System.out.println(token);

		return new JwtResponse(token);
	}

}
