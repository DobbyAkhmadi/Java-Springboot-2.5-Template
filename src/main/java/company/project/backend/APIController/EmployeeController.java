package company.project.backend.APIController;

import company.project.backend.Employee.Adapter.Out.EmployeeDto;
import company.project.backend.Employee.Application.UseCase.AddEmployeeUseCase;
import company.project.backend.Employee.Application.UseCase.DeleteEmployeeUseCase;
import company.project.backend.Employee.Application.UseCase.FindEmployeeUseCase;
import company.project.backend.Employee.Application.UseCase.ModifyEmployeeUseCase;
import company.project.backend.Employee.Domain.Employee;
import company.project.backend.utility.ResponseHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully retrieved list"),
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
@Api(tags="Employee", description = "Provides Employee Status API's.")
public class EmployeeController {
    private final AddEmployeeUseCase addEmployeeUseCase;
    private final FindEmployeeUseCase findEmployeeUseCase;
    private final ModifyEmployeeUseCase modifyEmployeeUseCase;
    private final DeleteEmployeeUseCase deleteEmployeeUseCase;

    @ApiOperation(value = "Retrieves all information about employee ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @GetMapping(value="",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllEmployees() {
        try {
            List<EmployeeDto> employeeDtoList = findEmployeeUseCase.loadAllEmployee();
            return ResponseHandler.requestStatus(employeeDtoList);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @ApiOperation(value = "Retrieves information about employee by id ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @GetMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") UUID uuid) {
        try {
            EmployeeDto employeeDto = findEmployeeUseCase.loadEmployeeById(uuid);
            return ResponseHandler.requestStatus(employeeDto);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @ApiOperation(value = "Create new information about employee ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @PostMapping(value = "",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee (@Valid Employee employeeBody) {
        try {
            EmployeeDto employeeDto = addEmployeeUseCase.saveEmployee(employeeBody);
            return ResponseHandler.requestStatus(employeeDto);
        }catch (Exception e)
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @ApiOperation(value = "Update new information about employee ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @PutMapping(value = "",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateEmployee (@Valid Employee employeeBody) {
        try {
            EmployeeDto employeeDto = modifyEmployeeUseCase.updateEmployee(employeeBody);
            return ResponseHandler.requestStatus(employeeDto);
        }catch (Exception e)
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @ApiOperation(value = "Delete information about employee by id ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @DeleteMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteEmployee (@PathVariable ("id") String id) {
        try {
            EmployeeDto employeeDto = deleteEmployeeUseCase.deleteEmployee(UUID.fromString(id));
            return ResponseHandler.requestStatus(employeeDto);
        }catch (Exception e)
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


}

