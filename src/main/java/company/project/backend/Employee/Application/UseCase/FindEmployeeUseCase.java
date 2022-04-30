package company.project.backend.Employee.Application.UseCase;

import company.project.backend.Employee.Adapter.out.EmployeeDto;

import java.util.List;
import java.util.UUID;

public interface FindEmployeeUseCase {
    List<EmployeeDto> loadAllEmployee() throws Exception;
    EmployeeDto loadEmployeeById(UUID uuid) throws Exception;
}
