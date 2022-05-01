package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Adapter.Out.Mapper.EmployeeMapper;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Application.UseCase.FindEmployeeUseCase;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindEmployeeService implements FindEmployeeUseCase {
    private final LoadEmployeePort loadEmployeePort;
    private final EmployeeMapper employeeMapper;
    @Override
    public List<EmployeeDto> loadAllEmployee() throws Exception {
        try
        {
            List<Employee> employeeList = loadEmployeePort.LoadAllEmployeePort();
            return employeeMapper.toEmployeeDtoList(employeeList);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public EmployeeDto loadEmployeeById(UUID uuid) throws Exception {
        try
        {
            Employee employees = loadEmployeePort.loadEmployeeById(uuid);
            return employeeMapper.toEmployeeDto(employees);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
