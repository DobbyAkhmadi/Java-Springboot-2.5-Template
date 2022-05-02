package company.project.backend.Employee.Application.Port.Out;

import java.util.UUID;

public interface DeleteEmployeePort {
    void deleteEmployeeById(UUID uuid) throws Exception;
}
