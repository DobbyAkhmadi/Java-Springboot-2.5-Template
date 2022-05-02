package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Application.Port.In.SaveEmployeePort;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModifyEmployeeService {
    private final LoadEmployeePort loadEmployeePort;
    private final SaveEmployeePort saveEmployeePort;
    public Employee updateEmployee(Employee employee) throws Exception {
        try {
            Optional<Employee> optionalEmployee = loadEmployeePort.loadEmployeeById(employee.getUuid());

            Employee employee1 = new Employee();
            employee.setUuid(optionalEmployee.get().getUuid());
            employee.setName(optionalEmployee.get().getName());
            employee.setAddress(optionalEmployee.get().getAddress());
            saveEmployeePort.storeEmployee(employee1);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
