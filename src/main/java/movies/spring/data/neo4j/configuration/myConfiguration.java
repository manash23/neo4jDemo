package movies.spring.data.neo4j.configuration;

import movies.spring.data.neo4j.domain.Movie;
import movies.spring.data.neo4j.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfiguration {
    @Bean
    public Movie getMovieInstance(){
        return new Movie();
    }
    @Bean
    public User getUserInstance(){
        return new User();
    }

}
