/**
 * 
 */
package com.bskyb.internettv.impl;

import static org.junit.Assert.*;

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

/**
 * @author rprasad
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceImplTest {
	
	@InjectMocks
	ParentalControlServiceImpl parentalControlServiceImpl;
	
	@InjectMocks
	MovieServiceImpl movieServiceImpl;
	
	private List<Movie> movies;

	private List<String> movieRating;
	
	@Before
	public void setUp() throws Exception {		
		movieRating = Arrays.asList("U","PG","12", "15","18");	
		
		movies = Arrays.asList(new Movie("M101","Movie - 1", "U"),
	               new Movie("M102","Movie - 2", "PG"),
	               new Movie("M103","Movie - 3", "12"),
	               new Movie("M104","Movie - 4", "15"),
	               new Movie("M105","Movie - 5", "18"),
	               new Movie("M106","Movie - 6", "U"));

        movieServiceImpl.setMovies(movies);
		parentalControlServiceImpl.setMovieRating(movieRating);
		parentalControlServiceImpl.setMovieServiceImpl(movieServiceImpl);
		
	}

	@Test
	public void testCanWatchMovie_CheckAccess() throws Exception {
		assertTrue(parentalControlServiceImpl.canWatchMovie("PG", "M101"));
	}
	
	@Test
	public void testCanWatchMovie_CheckNoAccess() throws Exception {
		assertFalse(parentalControlServiceImpl.canWatchMovie("U", "M104"));
	}
	
	@Test(expected=TitleNotFoundException.class)
	public void testCanWatchMovie_NoTitleFound() throws Exception {
		assertNull(parentalControlServiceImpl.canWatchMovie("U", "M1042343"));
	}
	
	
	@Test(expected=TechnicalFailureException.class)
	public void testCanWatchMovie_TechnicalIssues() throws Exception {
		assertNull(parentalControlServiceImpl.canWatchMovie("UG", "M104"));
	}
	
	
}
