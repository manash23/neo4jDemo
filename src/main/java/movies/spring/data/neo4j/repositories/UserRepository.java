package movies.spring.data.neo4j.repositories;
import movies.spring.data.neo4j.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;





    /**
     *
     * @author milandeket
     */
    public interface UserRepository extends Neo4jRepository<User,Long> {

    }

