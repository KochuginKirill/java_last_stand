package Spring.lesson4.service;

import Spring.lesson4.model.Project;
import Spring.lesson4.model.Timesheet;
import Spring.lesson4.page.ProjectPageDto;
import Spring.lesson4.page.TimesheetPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProjectPageService {
    private final TimesheetService timesheetService;
    private final ProjectService projectService;

    public List<ProjectPageDto> findAll() {
        return projectService.findAll().stream()
                .map(this::convert)
                .toList();
    }

    public Optional<ProjectPageDto> findById(Long id) {
        return projectService.findById(id) // Optional<Timesheet>
                .map(this::convert);
    }

    private ProjectPageDto convert(Project project) {

        ProjectPageDto projectPageParameters = new ProjectPageDto();
        projectPageParameters.setId(String.valueOf(project.getId()));
        projectPageParameters.setName(project.getName());


        return projectPageParameters;
    }
}
