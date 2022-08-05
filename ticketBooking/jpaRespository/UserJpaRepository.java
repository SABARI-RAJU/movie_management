package com.springBoot.ticketBooking.jpaRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.model.UserModel;

@Component
public interface UserJpaRepository extends JpaRepository<UserModel,Long> {
	
	UserModel findByusername(String username);

}
