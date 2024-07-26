package Spring.lesson8.repository;

import Spring.lesson8.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

  List<UserRole> findByUserId(Long userId);

}
