package company.project.backend.Employee.Adapter.Persistence.Repositories;

import company.project.backend.Employee.Domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, UUID> {

}