package demo;

import demo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProyectManagmentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProyectManagmentApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.testDevelopers();

        //employeeService.testEmployes();
        /*employeeService.testDevelopers();
        ManagerService managerService = context.getBean(ManagerService.class);
        managerService.testManager();
        ProjectService projectService = context.getBean(ProjectService.class);
        projectService.testProject();*/
    }
}
