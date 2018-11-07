package movies.spring.data.neo4j.service;

import movies.spring.data.neo4j.RecommendationData;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.User;
import movies.spring.data.neo4j.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServiceImpl implements Service {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    User user;

    @Override
    public ArrayList<Movie> saveLikes(Movie movie, User user){

        this.user.getWatchList().add(movie);
        return this.movieRepository.likes(movie,user);

    }

    @Override
    public ArrayList<Movie> saveDislikes(Movie movie, User user){

        return this.movieRepository.dislikes(movie,user);
    }

    @Override
    public List<RecommendationData> topFiveMovies(){
        return this.movieRepository.getTopFiveMovies();
    }

    @Override
    public Collection<Movie> getAllMovies(){

        return this.movieRepository.getAllMovies();

    }

    @Override
    public List<RecommendationData> getTrendingMovieByCity(String city){

        return this.movieRepository.sortByCity(city);
    }

    @Override
    public List<RecommendationData> getMovieByDefaultCity(){
        String city = this.user.getCity();
        return this.movieRepository.sortByCity(city);
    }


    @Override
    public List<RecommendationData> getMovieByLanguage(String language){
        return this.movieRepository.sortByLanguage(language);
    }

    @Override
    public List<RecommendationData> getMovieByDefaultLanguage(){
        String language = this.user.getLanguage();
        return this.movieRepository.sortByLanguage(language);
    }
}
