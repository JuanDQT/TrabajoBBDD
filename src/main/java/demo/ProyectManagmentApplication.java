package demo;

import demo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProyectManagmentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProyectManagmentApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.testEmployes();
    }
}
