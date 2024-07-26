package Spring.lesson8.repository;

import Spring.lesson8.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLogin(String login);

}
