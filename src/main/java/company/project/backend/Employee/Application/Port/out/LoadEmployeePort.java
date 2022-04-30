package company.project.backend.Employee.Application.Port.out;

import company.project.backend.Employee.Domain.Employee;

import java.util.List;
import java.util.UUID;

public interface LoadEmployeePort {
    List<Employee> LoadAllEmployeePort() throws Exception;
    Employee loadEmployeeById(UUID uuid) throws Exception;
}
