/*
package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.*;


@RelationshipEntity(type = "LIKES")
public class Relationship {

    @Id
    @GeneratedValue
    private Long relId;

    @StartNode
    private User person;

    @EndNode
    private Movie movie;

    public Relationship() {
    }

    public Relationship(Movie movie, User user) {
        this.movie = movie;
        this.person = user;
    }

    public Long getId() {
        return relId;
    }



    public User getUser() {
        return person;
    }

    public Movie getMovie() {
        return movie;
    }
}
*/
