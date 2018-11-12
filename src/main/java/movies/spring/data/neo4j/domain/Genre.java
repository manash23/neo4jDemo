package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;

@NodeEntity
public class Genre {
    @GraphId
    public Long graphId;

    @Relationship(type = "IS_OF")
    String genre;

    @Relationship(type = "INTERESTED_IN", direction = Relationship.INCOMING )
    ArrayList<String> genres;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public Genre(String genre, ArrayList<String> genres) {
        this.genre = genre;
        this.genres = genres;
    }
}
