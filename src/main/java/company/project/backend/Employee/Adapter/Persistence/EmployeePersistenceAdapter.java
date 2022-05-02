package company.project.backend.Employee.Adapter.Persistence;

import company.project.backend.Employee.Adapter.Persistence.Repositories.EmployeeRepository;
import company.project.backend.Employee.Application.Port.In.SaveEmployeePort;
import company.project.backend.Employee.Application.Port.Out.DeleteEmployeePort;
import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements LoadEmployeePort, SaveEmployeePort , DeleteEmployeePort {
   private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> LoadAllEmployeePaginationPort(Integer pageNo, Integer pageSize, String sortBy) throws Exception {
        try{
            Pageable paging =  PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
            Page<Employee> employeePage = employeeRepository.findAll(paging);
            return employeePage.getContent();
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }

    @Override
    public Optional<Employee> loadEmployeeById(UUID id) throws Exception {
        try{
            return employeeRepository.findById(id);
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
    public void deleteEmployeeById(UUID uuid) throws Exception {
        try{
            employeeRepository.deleteById(uuid);
        }catch (Exception e)
        {
            throw new Exception(e);
        }
    }
}





