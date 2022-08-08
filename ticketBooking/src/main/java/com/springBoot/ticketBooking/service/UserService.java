package com.springBoot.ticketBooking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springBoot.ticketBooking.jpaRespository.UserJpaRepository;
import com.springBoot.ticketBooking.model.UserModel;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username);
		System.out.println(userRepository.findByemail(username));
		UserModel user1 = userRepository.findByemail(username);
		if (user1 == null) {
			throw new UsernameNotFoundException(username);
//			System.out.println("ll");
		}
		else
		{
			System.out.println("kl");
			return new Wrapper(user1);
		}
		

//		return new User("admin", "password", new ArrayList<>());
	}
	
//
}
