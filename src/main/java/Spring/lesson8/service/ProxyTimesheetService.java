package Spring.lesson8.service;

import ru.gb.timesheet.model.Timesheet;

import java.util.Optional;

public class ProxyTimesheetService extends TimesheetService {

  private final TimesheetService original;

  public ProxyTimesheetService(TimesheetService original) {
    super(original);
    this.original = original;
  }

  @Override
  public Optional<Timesheet> findById(Long id) {
    // BEFORE
    Optional<Timesheet> result = null;
    try {
      result = original.findById(id);
      // AFTER RETURNING
    } catch (Throwable e) {
      // AFTER THROWING
      throw e;
    } finally {
      // AFTER
      return result;
    }
  }
}
