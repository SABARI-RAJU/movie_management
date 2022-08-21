package com.springBoot.ticketBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springBoot.ticketBooking.jpaRespository.MovieJpaRepository;
import com.springBoot.ticketBooking.model.Movielist;

@Component
public class AdminMoviesService {
	
	@Autowired
	private MovieJpaRepository movieJpaRepository;
	
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
	
	

}
