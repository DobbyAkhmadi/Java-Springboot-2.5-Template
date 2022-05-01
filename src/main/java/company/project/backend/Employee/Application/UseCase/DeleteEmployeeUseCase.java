package company.project.backend.Employee.Application.UseCase;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;

import java.util.UUID;

public interface DeleteEmployeeUseCase {
    EmployeeDto deleteEmployee(UUID uuid) throws Exception;
}
