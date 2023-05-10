package rest.webservices.restfulwebservices.user.jpa;

import org.springframework.stereotype.Repository;
import rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
