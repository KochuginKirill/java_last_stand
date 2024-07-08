package Spring.lesson3.service;

import org.springframework.stereotype.Service;
import Spring.lesson3.model.Timesheet;
import Spring.lesson3.repository.TimesheetRepository;

import java.util.List;
import java.util.Optional;

@Service // то же самое, что и Component
public class TimesheetService {

  private final TimesheetRepository repository;

  public TimesheetService(TimesheetRepository repository) {
    this.repository = repository;
  }

  public Optional<Timesheet> getById(Long id) {
    return repository.getById(id);
  }

  public List<Timesheet> getAll() {
    return repository.getAll();
  }

  public Timesheet create(Timesheet timesheet) {
    return repository.create(timesheet);
  }

  public void delete(Long id) {
    repository.delete(id);
  }

  public List<Timesheet> getAllByProject (Long id) {
    return repository.getAllByProject(id);
  }

}
