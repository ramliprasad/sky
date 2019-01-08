package com.bskyb.internettv.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bskyb.internettv.parental_control_service.ParentalControlService;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;

/**
 * The ParentalControlServiceImpl program implements the ParentalControlService 
 * Interface.
 * 
 * @author Prasad Ramalingam
 * @version 1.0
 *
 */

@Component
public class ParentalControlServiceImpl implements ParentalControlService {

	@Autowired
	private MovieService movieServiceImpl;
	
	@Resource(name="ratings")
	private List<String> movieRating;
	
	public void setMovieServiceImpl(MovieService movieServiceImpl) {
		this.movieServiceImpl = movieServiceImpl;
	}

	public void setMovieRating(List<String> movieRating) {
		this.movieRating = movieRating;
	}

	
	public MovieService getMovieServiceImpl() {
		return movieServiceImpl;
	}

	public List<String> getMovieRating() {
		return movieRating;
	}

	/* (non-Javadoc)
	 * @see com.bskyb.internettv.parental_control_service.ParentalControlService#canWatchMovie(java.lang.String, java.lang.String)
	 */
	public boolean canWatchMovie(String customerParentalControlLevel,
			String movieId) throws Exception{
		
		String movieLevel=null;
		
		// Check whether the provide customerParentalControlLevel is available in the ratings list
		if (!movieRating.contains(customerParentalControlLevel)){
			throw new TechnicalFailureException("Sorry, There was an issue with the Movie level. You cannot watch this movie");
		}
		
		try{
			// Retrieve movie level based on Id.
			movieLevel = movieServiceImpl.getParentalControlLevel(movieId);
		}catch(NullPointerException ne){
			throw new TitleNotFoundException("Sorry, Could not find the given movie.");
		}catch(TechnicalFailureException techE){
			throw new TechnicalFailureException("Sorry, There was a technical issue at this time. Please check back later.");
		}catch(TitleNotFoundException titeNFE){
			throw new TitleNotFoundException("Sorry, Could not find the given movie.");
		}
		
		// Return true if the user has access.
		return (movieRating.indexOf(movieLevel) <= movieRating.indexOf(customerParentalControlLevel));

	}
	
}