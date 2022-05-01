package company.project.backend.Employee.Application.Port.Out;

import company.project.backend.Employee.Domain.Employee;

import java.util.UUID;

public interface DeleteEmployeePort {
    Employee deleteEmployeeById(UUID uuid) throws Exception;
}
