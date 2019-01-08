package com.bskyb.internettv.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bskyb.internettv.bean.Movie;

/**
 * InternetTVContext class is used to initialize the spring Context.
 * @author Prasad Ramalingam
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.bskyb.internettv" })
public class InternetTVContext {
	
	@Bean(name="movies")
	public 	List<Movie> getMovies(){
		List<Movie> movieList = new ArrayList<Movie>();
		
		movieList.add(new Movie("M101","Movie - 1", "U"));
		movieList.add(new Movie("M102","Movie - 2", "PG"));
		movieList.add(new Movie("M103","Movie - 3", "12"));
		movieList.add(new Movie("M104","Movie - 4", "15"));
		movieList.add(new Movie("M105","Movie - 5", "18"));
		movieList.add(new Movie("M106","Movie - 5", "U"));
		
		return movieList;
	}
	
	
	@Bean(name="ratings")
	public List<String> getRatings(){
		List<String> ratings = Arrays.asList("U","PG","12", "15","18");	
		return ratings;
	}

}
