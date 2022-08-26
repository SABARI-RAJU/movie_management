package com.springBoot.ticketBooking.jpaRespository;

import java.sql.Date;
import java.util.List;

import javax.persistence.SqlResultSetMapping;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import com.springBoot.ticketBooking.model.Booking;
import com.springBoot.ticketBooking.model.FilterResponse;
import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.Shows;

@Component
public interface ShowJpaRepository extends JpaRepository<Shows, String> {

	@Query(value = "SELECT new com.springBoot.ticketBooking.model.FilterResponse("
			+ "m.title,"
			+ "m.movieurl,"
			+ "m.moviedescription,"
			+ "m.movieduration,"
			+ "m.movietype,"
			+ "u.showType,"
			+ "u.showDate,"
			+ "u.startTime,"
			+ "s.screename,"
			+ "h.name,"
			+ "h.city)"
			+ "FROM Movielist m,"
			+ "Shows u,"
			+ "cinemaScreen s,"
			+ "CinemaHall h WHERE u.showType LIKE CASE WHEN ?1 IS NOT NULL THEN ?1 ELSE '%' END and u.showDate LIKE CASE WHEN ?2 IS NOT NULL THEN ?2 ELSE '%' END and m.movietype LIKE CASE WHEN ?3 IS NOT NULL THEN ?3 ELSE '%' END  and s.screenid LIKE CASE WHEN ?4 IS NOT NULL THEN ?4 ELSE '%' END  and h.name LIKE CASE WHEN ?5 IS NOT NULL THEN ?5 ELSE '%' END and h.city LIKE CASE WHEN ?6 IS NOT NULL THEN ?6 ELSE '%' END  and m.movieid=u.movie.movieid and s.screenid=u.screen.screenid and h.cinemaHallId=s.hall.cinemaHallId")
	List<FilterResponse> findmovies(String showtype, Date showdate, String movietype, String screenid, String name,
			String city);

//	@Modifying
//	@Transactional
//	@Query(value = "create table +:name+ (phoneid varchar(150))",nativeQuery = true)
//	void createtable(String name);

}
