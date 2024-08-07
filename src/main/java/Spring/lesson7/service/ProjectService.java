package Spring.lesson7.service;

import Spring.lesson7.model.Timesheet;
import org.springframework.stereotype.Service;
import Spring.lesson7.model.Project;
import Spring.lesson7.model.Role;
import Spring.lesson7.repository.ProjectRepository;
import Spring.lesson7.repository.TimesheetRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final TimesheetRepository timesheetRepository;

  public ProjectService(ProjectRepository projectRepository, TimesheetRepository timesheetRepository) {
    this.projectRepository = projectRepository;
    this.timesheetRepository = timesheetRepository;
  }

  public Optional<Project> findById(Long id) {
    return projectRepository.findById(id);
  }

  public List<Project> findAll() {
    return projectRepository.findAll();
  }

  public Project create(Project project) {
    return projectRepository.save(project);
  }

  public void delete(Long id) {
    projectRepository.deleteById(id);
  }

  public List<Timesheet> getTimesheets(Long id) {
    if (projectRepository.findById(id).isEmpty()) {
      throw new NoSuchElementException("Project with id = " + id + " does not exists");
    }

    return timesheetRepository.findByProjectId(id);
  }
}
