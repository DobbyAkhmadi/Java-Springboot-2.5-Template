package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Application.Port.Out.DeleteEmployeePort;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteEmployeeService  {
    private final LoadEmployeePort loadEmployeePort;
    private final DeleteEmployeePort deleteEmployeePort;
    public Employee deleteEmployee(UUID uuid) throws Exception {
        try {
            Optional<Employee> optionalEmployee = loadEmployeePort.loadEmployeeById(uuid);
            Employee employee1 = new Employee();
            employee1.setUuid(optionalEmployee.get().getUuid());
            employee1.setName(optionalEmployee.get().getName());
            employee1.setAddress(optionalEmployee.get().getAddress());
            deleteEmployeePort.deleteEmployeeById(uuid);
            return employee1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
