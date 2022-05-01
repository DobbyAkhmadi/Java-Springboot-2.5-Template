package company.project.backend.Employee.Application.Port.In;

import company.project.backend.Employee.Domain.Employee;

public interface SaveEmployeePort {
    Employee saveEmployee(Employee employee) throws Exception;
    Employee storeEmployee(Employee employee) throws Exception;
}
