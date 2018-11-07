package movies.spring.data.neo4j.service;

import movies.spring.data.neo4j.RecommendationData;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@org.springframework.stereotype.Service
public interface Service {

    public ArrayList<Movie> saveLikes(Movie movie, User user);

    public ArrayList<Movie> saveDislikes(Movie movie, User user);

    public List<RecommendationData> topFiveMovies();

    public Collection<Movie> getAllMovies();

    public List<RecommendationData> getTrendingMovieByCity(String city);

    public List<RecommendationData> getMovieByDefaultCity();

    public List<RecommendationData> getMovieByLanguage(String language);

    public List<RecommendationData> getMovieByDefaultLanguage();
}
