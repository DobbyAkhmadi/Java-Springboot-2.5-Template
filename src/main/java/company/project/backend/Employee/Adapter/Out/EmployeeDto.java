package company.project.backend.Employee.Adapter.Out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private UUID id;
    private String name;
    private String address;
}
