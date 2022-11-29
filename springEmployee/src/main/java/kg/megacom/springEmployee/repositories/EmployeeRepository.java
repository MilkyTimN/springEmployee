package kg.megacom.springEmployee.repositories;

import kg.megacom.springEmployee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
