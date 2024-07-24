package Spring.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Spring.lesson8.model.Project ;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
