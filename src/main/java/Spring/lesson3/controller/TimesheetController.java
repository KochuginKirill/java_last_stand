package Spring.lesson3.controller;

import Spring.lesson3.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Spring.lesson3.model.Timesheet ;
import Spring.lesson3.service.TimesheetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {

  // GET - получить - не содержит тела
  // POST - create
  // PUT - изменение
  // PATCH - изменение
  // DELETE - удаление

  // @GetMapping("/timesheets/{id}") // получить конкретную запись по идентификатору
  // @DeleteMapping("/timesheets/{id}") // удалить конкретную запись по идентификатору
  // @PutMapping("/timesheets/{id}") // обновить конкретную запись по идентификатору

  private final TimesheetService service;
  private final ProjectService projectService;

  public TimesheetController(TimesheetService service, ProjectService projectService) {
    this.service = service;
    this.projectService = projectService;
  }



  // /timesheets/{id}
  @GetMapping("/{id}") // получить все
  public ResponseEntity<Timesheet> get(@PathVariable Long id) {
    Optional<Timesheet> ts = service.getById(id);

    if (ts.isPresent()) {
//      return ResponseEntity.ok().body(ts.get());
      return ResponseEntity.status(HttpStatus.OK).body(ts.get());
    }

    return ResponseEntity.notFound().build();
  }

  @GetMapping // получить все
  public ResponseEntity<List<Timesheet>> getAll() {
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping // создание нового ресурса
  public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
    if(projectService.getById(timesheet.getProjectId()).isPresent()){
      timesheet = service.create(timesheet);
    } else {
      throw new RuntimeException("No project with such id was found");
    }

    // 201 Created
    return ResponseEntity.status(HttpStatus.CREATED).body(timesheet);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);

    // 204 No Content
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/projects/{id}/timesheets")
  public ResponseEntity<List<Timesheet>> getAllByProject(@PathVariable Long id) {
    return ResponseEntity.ok(service.getAllByProject(id));
  }

}
