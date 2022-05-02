package company.project.backend.Employee.Application.Services;

import company.project.backend.Employee.Application.Port.Out.LoadEmployeePort;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindEmployeeService {
    private final LoadEmployeePort loadEmployeePort;

    public List<Employee> loadAllEmployeePagination(Integer pageNo, Integer pageSize, String sortBy) throws Exception {
        try
        {
            return loadEmployeePort.LoadAllEmployeePaginationPort(pageNo, pageSize,sortBy);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    public Employee loadEmployeeById(UUID uuid) throws Exception {
        try
        {
            Optional<Employee> employee = loadEmployeePort.loadEmployeeById(uuid);
            return employee.orElseThrow();
        } catch (Exception e) {
            throw new Exception(e);
        }

    }
}
