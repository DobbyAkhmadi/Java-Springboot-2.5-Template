package company.project.backend.Bootstrap;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AllLoader implements CommandLineRunner {
    private final EmployeeLoader employeeLoader;

    @Override
    public void run(String... args) throws Exception {
        employeeLoader.SetDefaultEmployee();
    }
}