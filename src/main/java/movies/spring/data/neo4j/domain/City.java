package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class City {
    @GraphId
    public Long graphId;

    @Relationship(type = "ARE_DISPLAYED_IN", direction = Relationship.INCOMING)
    List<Movie> movies;

    @Relationship(type = "ARE_FROM", direction = Relationship.INCOMING)
    List<User> users;

    @Relationship(type = "SPEAKS", direction = Relationship.OUTGOING)
    List<Language> languages;


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public City(){}

    public City(List<Movie> movies, List<User> users, List<Language> languages) {
        this.movies = movies;
        this.users = users;
        this.languages = languages;
    }
}
