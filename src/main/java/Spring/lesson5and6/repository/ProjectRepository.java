package Spring.lesson5and6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Spring.lesson5and6.model.Project;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
