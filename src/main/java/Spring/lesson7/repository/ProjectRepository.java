package Spring.lesson7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Spring.lesson7.model.Project;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
