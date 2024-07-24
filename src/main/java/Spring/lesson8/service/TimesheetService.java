package Spring.lesson8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Spring.lesson8.aspect.Timer;
import Spring.lesson8.model.Timesheet;
import Spring.lesson8.repository.ProjectRepository;
import Spring.lesson8.repository.TimesheetRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@Timer()
public class TimesheetService {

  private final TimesheetRepository timesheetRepository;
  private final ProjectRepository projectRepository;

  public TimesheetService(TimesheetService timesheetService) {
    this(timesheetService.timesheetRepository, timesheetService.projectRepository);
  }

  @Autowired
  public TimesheetService(TimesheetRepository repository, ProjectRepository projectRepository) {
    this.timesheetRepository = repository;
    this.projectRepository = projectRepository;
  }

//  @Timer
  public Optional<Timesheet> findById(Long id) {
    return timesheetRepository.findById(id);
  }

  public List<Timesheet> findAll() {
    return findAll(null, null);
  }

  public List<Timesheet> findAll(LocalDate createdAtBefore, LocalDate createdAtAfter) {
    // FIXME: Вернуть фильтрацию

    return timesheetRepository.findAll();
  }

  public Timesheet create(Timesheet timesheet) {
    if (Objects.isNull(timesheet.getProjectId())) {
      throw new IllegalArgumentException("projectId must not be null");
    }

    if (projectRepository.findById(timesheet.getProjectId()).isEmpty()) {
      throw new NoSuchElementException("Project with id " + timesheet.getProjectId() + " does not exists");
    }

    timesheet.setCreatedAt(LocalDate.now());
    return timesheetRepository.save(timesheet);
  }

//  @Timer(enabled = false)
  public void delete(Long id) {
    timesheetRepository.deleteById(id);
  }

}
