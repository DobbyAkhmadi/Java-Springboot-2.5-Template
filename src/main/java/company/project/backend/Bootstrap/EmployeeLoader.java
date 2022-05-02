package company.project.backend.Bootstrap;


import com.github.javafaker.Faker;
import company.project.backend.Employee.Adapter.Persistence.Repositories.EmployeeRepository;
import company.project.backend.Employee.Domain.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeLoader  {
    private final EmployeeRepository employeeRepository;

    public List<Employee> SetDefaultEmployee()
    {
        List<Employee> employeeList = new ArrayList<>();

        for (int i=0; i<100;i++)
        {
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String streetAddress = faker.address().streetAddress();
            Employee employee = Employee.builder()
                    .address(streetAddress)
                    .name(name).build();
            employeeList.add(employee);
        }
        return (List<Employee>) employeeRepository.saveAll(employeeList);
    }
}