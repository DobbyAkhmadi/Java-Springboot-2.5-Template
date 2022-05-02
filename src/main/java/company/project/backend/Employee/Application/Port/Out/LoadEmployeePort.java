package company.project.backend.Employee.Application.Port.Out;

import company.project.backend.Employee.Domain.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoadEmployeePort {

    List<Employee> LoadAllEmployeePaginationPort(Integer pageNo, Integer pageSize, String sortBy) throws Exception;
    Optional<Employee> loadEmployeeById(UUID uuid) throws Exception;
}
