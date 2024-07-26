package Spring.lesson8.service;

import Spring.lesson8.client.TimesheetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import Spring.lesson8.page.TimesheetPageDto;
import org.springframework.web.client.RestClient;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimesheetPageService {
  private final RestClient restClient;
  public TimesheetPageService() {
    this.restClient = RestClient.create("http:/localhost:8080");
  }

  public List<TimesheetPageDto> findAll() {
    List<TimesheetResponse> timesheets = restClient.get()
            .uri("/timesheets")
            .retrieve()
            .body(new ParameterizedTypeReference<List<TimesheetResponse>>() {
            });

    List<TimesheetPageDto> result;
    for (TimesheetResponse timesheet : timesheets){
      TimesheetPageDto timesheetPageDto = new TimesheetPageDto();
      timesheetPageDto.setId(String.valueOf(timesheet.getId()));
      timesheetPageDto.setMinutes(String.valueOf(timesheet.getMinutes()));
      timesheetPageDto.setCreatedAt(timesheet.getCreatedAt().format(DateTimeFormatter.ISO_DATE));


    }

    return timesheetService.findAll().stream()
      .map(this::convert)
      .toList();
  }

  public Optional<TimesheetPageDto> findById(Long id) {
    return timesheetService.findById(id) // Optional<Timesheet>
      .map(this::convert);
  }

  private TimesheetPageDto convert(Timesheet timesheet) {
    Project project = projectService.findById(timesheet.getProjectId())
      .orElseThrow();

    TimesheetPageDto timesheetPageParameters = new TimesheetPageDto();
    timesheetPageParameters.setProjectName(project.getName());
    timesheetPageParameters.setId(String.valueOf(timesheet.getId()));
    // 150 -> 2h30m
    timesheetPageParameters.setMinutes(String.valueOf(timesheet.getMinutes()));
    timesheetPageParameters.setCreatedAt(timesheet.getCreatedAt().format(DateTimeFormatter.ISO_DATE));

    return timesheetPageParameters;
  }

}
