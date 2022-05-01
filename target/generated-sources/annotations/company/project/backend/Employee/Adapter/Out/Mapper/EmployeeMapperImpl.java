package company.project.backend.Employee.Adapter.Out.Mapper;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Adapter.Out.EmployeeDto.EmployeeDtoBuilder;
import company.project.backend.Employee.Domain.Employee;
import company.project.backend.Employee.Domain.Employee.EmployeeBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-02T01:27:05+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.id( employee.getId() );
        employeeDto.name( employee.getName() );
        employeeDto.address( employee.getAddress() );

        return employeeDto.build();
    }

    @Override
    public Employee toEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.id( employeeDto.getId() );
        employee.name( employeeDto.getName() );
        employee.address( employeeDto.getAddress() );

        return employee.build();
    }

    @Override
    public List<EmployeeDto> toEmployeeDtoList(List<Employee> employee) {
        if ( employee == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employee.size() );
        for ( Employee employee1 : employee ) {
            list.add( toEmployeeDto( employee1 ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEmployeeList(List<Employee> employeeDtoList) {
        if ( employeeDtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeDtoList.size() );
        for ( Employee employee : employeeDtoList ) {
            list.add( employee );
        }

        return list;
    }
}
