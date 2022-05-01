package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Adapter.Out.Mapper.EmployeeMapper;
import company.project.backend.Employee.Application.Port.Out.DeleteEmployeePort;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Application.UseCase.DeleteEmployeeUseCase;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteEmployeeService implements DeleteEmployeeUseCase {
    private final LoadEmployeePort loadEmployeePort;
    private final DeleteEmployeePort deleteEmployeePort;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto deleteEmployee(UUID uuid) throws Exception {
        try {
            Employee employee =  deleteEmployeePort.deleteEmployeeById(uuid);
            return employeeMapper.toEmployeeDto(employee);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
