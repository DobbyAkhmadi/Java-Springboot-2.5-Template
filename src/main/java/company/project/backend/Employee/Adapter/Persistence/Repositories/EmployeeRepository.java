package company.project.backend.Employee.Adapter.Persistence.Repositories;

import company.project.backend.Employee.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee getById(UUID id);

    Employee deleteById(UUID uuid);
}