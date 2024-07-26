package Spring.lesson8.repository;

import Spring.lesson8.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
