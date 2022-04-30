package company.project.backend.Employee.Adapter.out.mapper;

import company.project.backend.Employee.Adapter.out.EmployeeDto;
import company.project.backend.Employee.Domain.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
    // get one
    EmployeeDto toEmployeeDto(Employee employee);
    Employee toEmployee(EmployeeDto employeeDto);
    // get all
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employee);
    List<Employee> toEmployeeList(List<Employee> employeeDtoList);
}
