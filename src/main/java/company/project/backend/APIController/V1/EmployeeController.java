package company.project.backend.APIController.V1;

import company.project.backend.Employee.Adapter.Persistence.Repositories.EmployeeRepository;
import company.project.backend.Employee.Application.Services.AddEmployeeService;
import company.project.backend.Employee.Application.Services.DeleteEmployeeService;
import company.project.backend.Employee.Application.Services.FindEmployeeService;
import company.project.backend.Employee.Application.Services.ModifyEmployeeService;
import company.project.backend.Employee.Domain.Employee;
import company.project.backend.utility.IResponseNormal;
import company.project.backend.utility.IResponsePagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully retrieved/update/delete list"),
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @io.swagger.annotations.ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @io.swagger.annotations.ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
@Api(tags="Employee", description = "Provides Employee Status API's.")
public class EmployeeController {
    private final AddEmployeeService addEmployeeService;
    private final FindEmployeeService findEmployeeService;
    private final ModifyEmployeeService modifyEmployeeService;
    private final DeleteEmployeeService deleteEmployeeService;
    private final EmployeeRepository employeeRepository;
    @ApiOperation(value = "Retrieves all information about employee with pagination",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @GetMapping(value="",produces = APPLICATION_JSON_VALUE)
    public List<Object> getAllEmployeePagination(@RequestParam (defaultValue = "0") Integer no,
                                                 @RequestParam (defaultValue = "10") Integer size,
                                                 @RequestParam (defaultValue = "uuid")String sort) {
        try {
            Pageable paging =  PageRequest.of(no, size, Sort.by(sort));
            Page<Employee> employeePage = employeeRepository.findAll(paging);
            if (employeePage.getTotalElements()==0)
            {
                return IResponsePagination.requestStatus ("The resource you were trying to reach is not found", HttpStatus.valueOf(404), null,no,size,sort);
            }
            return IResponsePagination.requestStatus ("Successfully retrieved list", HttpStatus.valueOf(200),employeePage.getContent(),no,size,sort);
        } catch(Exception e) {
           return IResponsePagination.requestStatus (e.getMessage(), HttpStatus.valueOf(404), null,no,size,sort);
        }
    }

    @ApiOperation(value = "Retrieves information about employee by id ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @GetMapping(value = "/uuid",produces = APPLICATION_JSON_VALUE)
    public Object getEmployeeById(@Valid Employee employeeBody) {
        try {
            UUID uuid = employeeBody.getUuid();
            Employee employee = findEmployeeService.loadEmployeeById(uuid);
            return IResponseNormal.requestStatus("Successfully retrieved list",HttpStatus.valueOf(200),employee);
        } catch(Exception e) {
            return IResponseNormal.requestStatus (e.getMessage(), HttpStatus.valueOf(404), null);
        }
    }

    @ApiOperation(value = "Create new information about employee ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @PostMapping(value = "",produces = APPLICATION_JSON_VALUE)
    public Object createEmployee (@Valid Employee employeeBody) {
        try {
            Employee employee = addEmployeeService.saveEmployee(employeeBody);
            return IResponseNormal.requestStatus("Successfully added list",HttpStatus.valueOf(200),employee);
        }catch (Exception e)
        {
            return IResponseNormal.requestStatus (e.getMessage(), HttpStatus.valueOf(404), null);
        }
    }

    @ApiOperation(value = "Update new information about employee ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @PutMapping(value = "",produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object updateEmployee (@Valid Employee employeeBody) {
        try {
            Employee employee = modifyEmployeeService.updateEmployee(employeeBody);
            return IResponseNormal.requestStatus("Successfully updated list",HttpStatus.valueOf(200),employee);
        }catch (Exception e)
        {
            return IResponseNormal.requestStatus (e.getMessage(), HttpStatus.valueOf(404), null);
        }
    }

    @ApiOperation(value = "Delete information about employee by id ",
            notes = "Get a business {@link Company} containing information that describes the company",
            produces = APPLICATION_JSON_VALUE,
            response = Employee.class)
    @DeleteMapping(value = "/uuid",produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    private Object deleteEmployee (@Valid Employee employeeBody) {
        try {
            UUID uuid = employeeBody.getUuid();
            Employee employee  = deleteEmployeeService.deleteEmployee(uuid);
            return IResponseNormal.requestStatus("Successfully deleted list",HttpStatus.valueOf(200),employee);
        }catch  (Exception e)
        {
            return IResponseNormal.requestStatus (e.getMessage(), HttpStatus.valueOf(404), null);
        }
    }

}

