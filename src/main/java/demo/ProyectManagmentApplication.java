package demo;

import demo.service.EmployeeService;
import demo.service.ManagerService;
import demo.service.ProjectService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProyectManagmentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProyectManagmentApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        //employeeService.testEmployes();
        //employeeService.testDevelopers();
        ManagerService managerService = context.getBean(ManagerService.class);
        managerService.testManager();
        ProjectService projectService = context.getBean(ProjectService.class);
        projectService.testProject();
    }
}
