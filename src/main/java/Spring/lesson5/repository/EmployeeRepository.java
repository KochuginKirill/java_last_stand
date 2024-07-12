package Spring.lesson5.repository;

import Spring.lesson5.model.Employee;
import Spring.lesson5.model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
