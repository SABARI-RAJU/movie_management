package com.springBoot.ticketBooking.jpaRespository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.springBoot.ticketBooking.model.Booking;


@Component
public interface BookingJpaRepository extends JpaRepository<Booking,Long> {
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE screen_seat SET status = 1,bookingid = ?3 WHERE showid = ?1 and seat_number in ?2",nativeQuery = true)
	void bookseat(String showid,List<String> seatno,String bookingid);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE screen_seat SET status = 0,bookingid = NULL WHERE bookingid = ?1"
	,nativeQuery = true)
	void cancelTicket(String bookingid);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE booking SET cancelstatus = 1 WHERE bookingid = ?1"
	,nativeQuery = true)
	void updateBookingStatus(String bookingid);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE screen_seat SET reserved = 1 WHERE showid = ?1 and seat_number in ?2"
	,nativeQuery = true)
	void reserveSeat(String showid,List<String> seatno);
	
	
	@Query(value = "select reserved from screen_seat where showid = ?1 and seat_number in ?2"
	,nativeQuery = true)
	List<Object> checkIsReserved(String showid,List<String> seatno);
	
	@Query(value = "Select price from screen_seat where showid=?1 and seat_number in ?2",nativeQuery = true)
	List<Object> getPrice(String showId, List<String> seatno);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE booking SET payment_status = 1 WHERE bookingid= ?1"
	,nativeQuery = true)
	void setPaymentStatus(String bookingid);

	Booking findByBookingid(String bookingid);
	
	
	

}
