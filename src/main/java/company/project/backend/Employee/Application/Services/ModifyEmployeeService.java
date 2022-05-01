package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Adapter.Out.Mapper.EmployeeMapper;
import company.project.backend.Employee.Application.Port.In.SaveEmployeePort;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Application.UseCase.ModifyEmployeeUseCase;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyEmployeeService implements ModifyEmployeeUseCase {
    private final LoadEmployeePort loadEmployeePort;
    private final SaveEmployeePort saveEmployeePort;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto updateEmployee(Employee employee) throws Exception {
        try {
            Employee mEmployee = loadEmployeePort.loadEmployeeById(employee.getId());
            mEmployee.setAddress(employee.getAddress());
            mEmployee.setName(employee.getName());
            saveEmployeePort.storeEmployee(mEmployee);
            return employeeMapper.toEmployeeDto(employee);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
