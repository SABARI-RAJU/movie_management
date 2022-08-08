package com.springBoot.ticketBooking.jpaRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.model.UserModel;

@Component
public interface UserJpaRepository extends JpaRepository<UserModel,String> {
	
	UserModel findByemail(String username);
//	UserModel findByusername(String username);
	

}
