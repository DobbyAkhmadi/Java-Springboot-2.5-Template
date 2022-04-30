package company.project.backend.APIController;

import company.project.backend.Employee.Adapter.out.EmployeeDto;
import company.project.backend.Employee.Application.UseCase.FindEmployeeUseCase;
import company.project.backend.utility.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final FindEmployeeUseCase findEmployeeUseCase;
    @ApiOperation(value = "Retrieves all information about employee ")
    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @GetMapping("")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() throws Exception {
        try {
            List<EmployeeDto> employeeDtoList = findEmployeeUseCase.loadAllEmployee();
            return ResponseEntity.ok().body(employeeDtoList);
        } catch(Exception e) {
            throw new ResourceNotFoundException("Resource Not Found");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") UUID uuid) throws Exception {

        try {
            EmployeeDto employeeDto = findEmployeeUseCase.loadEmployeeById(uuid);
            return ResponseEntity.ok().body(employeeDto);
        } catch(Exception e) {
            throw new ResourceNotFoundException("Resource Not Found For This ID :: "+uuid);
        }
    }

}

