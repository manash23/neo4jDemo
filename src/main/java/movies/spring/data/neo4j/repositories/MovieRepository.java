package movies.spring.data.neo4j.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import movies.spring.data.neo4j.RecommendationData;
import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends Neo4jRepository<Movie, Long> {


//	Movie findByTitle(@Param("title") String title);
//
//	Collection<Movie> findByTitleLike(@Param("title") String title);
//
//    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
//	Collection<Movie> graph(@Param("limit") int limit);


	@Query("MATCH (m:Movie)<-[l:LIKES]-(u:User) "
			+ "RETURN m.movieId as id, count(l) as likes "
			+ "ORDER BY likes DESC "
			+ "LIMIT 5")
	public List<RecommendationData> getTopFiveMovies();

	@Query("MATCH (m:Movie)" + "RETURN m")
	public Collection<Movie> getAllMovies();

	@Query("MATCH (m:Movie)" + "WHERE m.city: {city}" + "ORDER BY m.yearOfRelease, m.likes" + "RETURN m")
	public List<RecommendationData> sortByCity(String city);

	@Query("MATCH (m:Movie)" + "WHERE m.language: {language}" + "ORDER BY m.yearOfRelease, m.likes" + "RETURN m")
	public List<RecommendationData> sortByLanguage(String language);

	@Query("MATCH (user:User{name: user})" + "CREATE (user) - [:LIKES] -> (movie3: Movie)" +"RETURN user,movie3")
	public ArrayList<Movie> likes(Movie movie, User user);

	@Query("MATCH (user:User{name: user})" + "CREATE (user) - [:DISLIKES] -> (movie3: Movie)" +"RETURN user,movie3")
	public ArrayList<Movie> dislikes(Movie movie, User user);
}