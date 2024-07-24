package Spring.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.timesheet.model.Project;

//@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
