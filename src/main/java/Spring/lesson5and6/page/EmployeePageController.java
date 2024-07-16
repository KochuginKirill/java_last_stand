package Spring.lesson5and6.page;

import Spring.lesson5and6.model.Employee;
import Spring.lesson5and6.service.EmployeeService;
import Spring.lesson5and6.service.TimesheetPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/home/employees")
@RequiredArgsConstructor
public class EmployeePageController {
    private final EmployeeService service;
    private  final TimesheetPageService serviceTimesheet;

    // Вместо описания, можно использовать @RequiredArgsConstructor
//  public TimesheetPageController(TimesheetService service) {
//    this.service = service;
//  }

    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> timesheets = service.findAll();
        model.addAttribute("employees", timesheets);
        return "lesson5_employees.html";
    }

    // GET /home/timesheets/{id}
    @GetMapping("/{id}")
    public String getEmployeePage(@PathVariable Long id, Model model) {
        Optional<Employee> timesheetOpt = service.findById(id);
        if (timesheetOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        model.addAttribute("employee", timesheetOpt.get());
        return "lesson5_employee.html";
    }

    @GetMapping("/{id}/timesheets")
    public String getTimesheetPage(@PathVariable Long id, Model model){
        List<TimesheetPageDto> timesheets = serviceTimesheet.getTimesheetsByEmployeeId(id);
        if (timesheets.isEmpty()) {
            throw new NoSuchElementException();
        }
        model.addAttribute("timesheets", timesheets);
        return "lesson5_timesheets-page.html";
    }
}
