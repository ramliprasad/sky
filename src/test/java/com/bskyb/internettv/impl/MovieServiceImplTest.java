package com.bskyb.internettv.impl;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.bskyb.internettv.bean.Movie;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

	@InjectMocks
	MovieServiceImpl movieServiceImpl;	
	
	private List<Movie> movies;
	
    @Before
    public void setUp() throws Exception {
    	
		movies = Arrays.asList(new Movie("M101","Movie - 1", "U"),
				               new Movie("M102","Movie - 2", "PG"),
				               new Movie("M103","Movie - 3", "12"),
				               new Movie("M104","Movie - 4", "15"),
				               new Movie("M105","Movie - 5", "18"),
				               new Movie("M106","Movie - 6", "U"));
	    
		movieServiceImpl.setMovies(movies);
	       		
    }

	@Test
	public void testGetParentalControlLevel_CheckRatingReturn() throws TechnicalFailureException, TitleNotFoundException {
		assertThat("U",equalTo(movieServiceImpl.getParentalControlLevel("M101")));		
	}
	
	@Test(expected=TitleNotFoundException.class)
	public void testGetParentalControlLevel_RatingUnavailable() throws TechnicalFailureException, TitleNotFoundException {		
		assertThat(null,(equalTo(movieServiceImpl.getParentalControlLevel("M107"))));		
	}
	
}