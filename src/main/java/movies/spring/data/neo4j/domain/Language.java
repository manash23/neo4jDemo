package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Language {
    @GraphId
    public Long graphId;

    @Relationship(type = "SPEAKS", direction = Relationship.INCOMING)
    String language;


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Language( String language) {

        this.language = language;
    }
}
