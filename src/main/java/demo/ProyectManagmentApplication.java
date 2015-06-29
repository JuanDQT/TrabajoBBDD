package demo;

import demo.service.DeveloperService;
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
        ManagerService managerService = context.getBean(ManagerService.class);
        ProjectService projectService = context.getBean(ProjectService.class);
        DeveloperService developerService = context.getBean(DeveloperService.class);

        employeeService.testEmployes();
        managerService.testManager();
        projectService.testProject();
        developerService.testDeveloper();
    }
}
