package Spring.lesson5and6.repository;

import Spring.lesson5and6.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
