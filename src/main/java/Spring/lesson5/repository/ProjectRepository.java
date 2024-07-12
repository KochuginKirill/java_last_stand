package Spring.lesson5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Spring.lesson5.model.Project;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
