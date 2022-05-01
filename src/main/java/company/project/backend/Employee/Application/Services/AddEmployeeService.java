package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Adapter.Out.Mapper.EmployeeMapper;
import company.project.backend.Employee.Application.Port.In.SaveEmployeePort;
import company.project.backend.Employee.Application.UseCase.AddEmployeeUseCase;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddEmployeeService implements AddEmployeeUseCase {
    private final SaveEmployeePort saveEmployeePort;
    private final EmployeeMapper employeeMapper;
    @Override
    public EmployeeDto saveEmployee(Employee employee) throws Exception {
        try{
            Employee mEmployee = saveEmployeePort.saveEmployee(employee);
            return employeeMapper.toEmployeeDto(mEmployee);
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }
}
