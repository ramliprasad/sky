package com.bskyb.internettv.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bskyb.internettv.bean.Movie;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;

import javax.annotation.Resource;
/**
 * MovieServiceImpl class implements the MovieService interface. 
 * The class is used to fetch movie rating based on movie id. 
 * @author Prasad Ramalingam
 *
 */
@Component
public class MovieServiceImpl implements MovieService {
	
	@Resource(name="movies")
	private List<Movie> movies;

	public String getParentalControlLevel(String titleId)
			throws TechnicalFailureException, TitleNotFoundException {
		
		boolean titleFound=false;
				
		for (Movie movie: movies) {
			if (movie.getId().equals(titleId)){
				titleFound=true;
				return movie.getRating();
			}
		}
		
		// if Movie not found then throw an exception
		if(!titleFound){
			throw new TitleNotFoundException("Sorry, Could not find the given movie.");
		}
		
		return null; 
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
