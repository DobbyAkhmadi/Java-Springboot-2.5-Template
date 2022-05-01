package company.project.backend.Employee.Application.UseCase;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Domain.Employee;

public interface ModifyEmployeeUseCase {
    EmployeeDto updateEmployee( Employee employee) throws Exception;
}
