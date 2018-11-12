package movies.spring.data.neo4j.controller;

import java.util.*;

import movies.spring.data.neo4j.RecommendationData;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.User;
import movies.spring.data.neo4j.repositories.MovieRepository;
import movies.spring.data.neo4j.repositories.UserRepository;

import movies.spring.data.neo4j.service.Service;
import movies.spring.data.neo4j.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/recommendation")
public class MovieController {


	@Autowired
	private UserRepository userRepo;

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private Movie movie;

	@Autowired
	private User user;

	@Autowired
    private Service service;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Collection<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		this.userRepo.findAll().forEach(u -> {
			users.add(u);
		});
		return users;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public Collection<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<>();
		this.movieRepo.findAll().forEach(m -> {
			movies.add(m);
		});
		return movies;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Movie> guestMovies(){
		List<Movie> movies = new ArrayList<>();
		this.movieRepo.findAll().forEach(m -> {
			movies.add(m);
		});
		return movies;
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "userId") Long userId){
		return this.userRepo.findById(userId).get();
	}

	@RequestMapping(value = "/recommend/user/{userId}", method = RequestMethod.GET)
	public Collection<RecommendationData> getRecommendationForUser(@PathVariable(name = "userId") Long userId){
		Collection<RecommendationData> data = this.movieRepo.getTopFiveMovies();

		// If there is no recommended movies, return top 5
		if(data == null || data.isEmpty()){

		}
		return data;
	}



	@PostMapping(value = "/like")
	public ResponseEntity <?> saveLikesUser(@RequestBody Movie movie, @RequestBody User user) {

		ResponseEntity responseEntity;

		this.service.saveLikes(movie,user);

		try{
			responseEntity = new ResponseEntity<String>("Successfully saved", HttpStatus.CREATED);
		} catch (Exception ex){
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}

		return responseEntity;

	}


	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable(name = "movieId") Long movieId){
		return this.movieRepo.findById(movieId).get();
	}
}
