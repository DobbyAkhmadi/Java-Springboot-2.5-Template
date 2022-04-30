package company.project.backend.Employee.Adapter.persistence;

import company.project.backend.Employee.Adapter.persistence.repositories.EmployeeRepository;
import company.project.backend.Employee.Application.Port.out.LoadEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements LoadEmployeePort {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> LoadAllEmployeePort() throws Exception {
        return employeeRepository.findAll();
    }

    @Override
    public Employee loadEmployeeById(UUID id) throws Exception {
        return employeeRepository.getById(id);
    }
}





