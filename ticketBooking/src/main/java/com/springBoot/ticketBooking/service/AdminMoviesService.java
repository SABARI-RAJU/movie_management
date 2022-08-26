package com.springBoot.ticketBooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.jpaRespository.CinemaScreenJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.MovieJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.SeatJpaRepository;
import com.springBoot.ticketBooking.jpaRespository.ShowJpaRepository;
import com.springBoot.ticketBooking.model.FilterResponse;
import com.springBoot.ticketBooking.model.Movielist;
import com.springBoot.ticketBooking.model.ScreenSeat;
import com.springBoot.ticketBooking.model.ShowFilter;
import com.springBoot.ticketBooking.model.Shows;

@Component
public class AdminMoviesService {
	
	@Autowired
	private MovieJpaRepository movieJpaRepository;
	
	@Autowired
	private ShowJpaRepository showJpaRepository;
	
	@Autowired
	private SeatJpaRepository seatJpaRepository;
	
	@Autowired
	private CinemaScreenJpaRepository cinemaScreenJpaRepository;
	
	public void addmoviesService(Movielist movies)
	{
		
		System.out.println(movies.getMovieid());
		movieJpaRepository.save(movies);
		
	}
	
	public void updatemoviesService(Movielist movies)
	{
		
		System.out.println(movies.getMovieid());
		Movielist movieDetail=movieJpaRepository.findByTitle(movies.getTitle());
		System.out.println(movieDetail.getMovietype());
		if(movies.getMovietype()!=null)
		{
			movieDetail.setMovietype(movies.getMovietype());
		}
		if(movies.getMovieurl()!=null)
		{
			movieDetail.setMovieurl(movies.getMovieurl());
		}
		
		if(movies.getMovieduration()!=null)
		{
			movieDetail.setMovieduration(movies.getMovieduration());
		}
		movieJpaRepository.save(movieDetail);
		
	}

	public List<Movielist> allMovies() {
		try
		{
			return movieJpaRepository.findAll();
		}
		catch(Exception e)
		{
			return (List<Movielist>)e;
		}
		
	}

	public List<FilterResponse> movieFilter(ShowFilter filter) {
		try
		{
			return showJpaRepository.findmovies(filter.getShowtype(),filter.getShowdate(),filter.getMovietype(),filter.getScreenid(),filter.getName(),filter.getCity());
		}
		catch(Exception e)
		{
			return (List<FilterResponse>) e;
		}
		
	}

	public String createShow(Shows show) {
		System.out.println(show.getScreen().getScreenid().toString());
		show.setShowId("#"+show.getShowDate()+""+show.getShowType()+""+show.getScreen().getScreenid());
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
		
		return "Show created Successfully!!";
	}
	
	

}
