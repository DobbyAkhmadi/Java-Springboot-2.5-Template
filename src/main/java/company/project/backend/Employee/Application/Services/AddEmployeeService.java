package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Application.Port.In.SaveEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddEmployeeService {
    private final SaveEmployeePort saveEmployeePort;

    public Employee saveEmployee(Employee employee) throws Exception {
        try{
            return saveEmployeePort.saveEmployee(employee);
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }
}
