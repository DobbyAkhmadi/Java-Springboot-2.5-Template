package company.project.backend.Employee.Adapter.Persistence;

import company.project.backend.Employee.Adapter.Persistence.Repositories.EmployeeRepository;
import company.project.backend.Employee.Application.Port.In.SaveEmployeePort;
import company.project.backend.Employee.Application.Port.Out.DeleteEmployeePort;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements LoadEmployeePort, SaveEmployeePort , DeleteEmployeePort {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> LoadAllEmployeePort() throws Exception {
        try{
            return employeeRepository.findAll();
        }catch (Exception e)
        {
            throw  new Exception(e);
        }
    }

    @Override
    public Employee loadEmployeeById(UUID id) throws Exception {
        try{
            return employeeRepository.getById(id);
        }catch (Exception e)
        {
            throw new Exception(e);
        }

    }

    @Override
    public Employee saveEmployee(Employee employee) throws Exception {
        try{
            return employeeRepository.save(employee);
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }

    @Override
    public Employee storeEmployee(Employee employee) throws Exception {
        try{
            return employeeRepository.save(employee);
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }

    @Override
    public Employee deleteEmployeeById(UUID uuid) throws Exception {
        try{
            return employeeRepository.deleteById(uuid);
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }
}





