package com.springBoot.ticketBooking.jpaRespository;

import java.util.List;

import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import com.springBoot.ticketBooking.model.Booking;
import com.springBoot.ticketBooking.model.FilterResponse;
import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.Shows;


@Component
public interface ShowJpaRepository extends JpaRepository<Shows,String> {
	
	@Query(value = "SELECT m.title,m.movieurl,m.moviedescription,m.movieduration,m.movietype,u.show_type,u.show_date,u.start_time,s.screename,h.name,h.city FROM movielist m,shows u,cinema_screen s,cinema_hall h WHERE u.show_type LIKE CASE WHEN ?1 IS NOT NULL THEN ?1 ELSE \\\"%\\\" END and u.show_date LIKE CASE WHEN ?2 IS NOT NULL THEN ?2 ELSE \\\"%\\\" END and m.movietype LIKE CASE WHEN ?3 IS NOT NULL THEN ?3 ELSE \\\"%\\\" END  and s.screenid LIKE CASE WHEN ?4 IS NOT NULL THEN ?4 ELSE \"%\" END  and h.name LIKE CASE WHEN ?5 IS NOT NULL THEN ?5 ELSE \"%\" END and h.city LIKE CASE WHEN ?6 IS NOT NULL THEN ?6 ELSE \"%\" END  and m.movieid=u.movieid and s.screenid=u.screenid and h.cinema_hall_id=s.cinema_hall_id", nativeQuery = true)
	
	List<FilterResponse> findmovies(String showtype,String showdate,String movietype,String screenid,String name,String city);
	

}
