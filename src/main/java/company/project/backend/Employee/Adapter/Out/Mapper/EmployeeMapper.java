package company.project.backend.Employee.Adapter.Out.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
    // get one
    //EmployeeDto toEmployeeDto(Employee employee);
   // Employee toEmployee(EmployeeDto employeeDto);
    // get all
 //   List<EmployeeDto> toEmployeeDtoList(List<Employee> employee);
  //  List<Employee> toEmployeeList(List<Employee> employeeDtoList);
}
