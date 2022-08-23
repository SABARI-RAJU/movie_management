package com.springBoot.ticketBooking.jpaRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.UserModel;

@Component
public interface MovieJpaRepository extends JpaRepository<Movielist,String> {
	Movielist findByTitle(String title);
	

}
