package rest.webservices.restfulwebservices.user.jpa;

import org.springframework.stereotype.Repository;
import rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
