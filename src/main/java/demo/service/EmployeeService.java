package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 16/06/2015.
 */

//base de datos
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    //@Autowired
    //private ManagerRepository managerRepository;

    public void testEmployes(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.JANUARY,1);
        Date startDate = calendar.getTime();

        calendar.set(2015, Calendar.MARCH,1);
        Date endDate = calendar.getTime();

        calendar.set(2015, Calendar.FEBRUARY,1);
        Date dateIncorporation = calendar.getTime();

        Employee employee = new Employee();
        employee.setName("Carlos");
        employee.setSurname("Mendez");
        employee.setSalary(1000.0);
        employee.setDtIni(new Date());
        employee.setDtIni(dateIncorporation);

        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("Cesar");
        employee2.setSurname("Jimenez");
        employee2.setSalary(100.0);
        employee2.setDtIni(new Date());

        employeeRepository.save(employee2);

        Employee mendez = employeeRepository.findBySurname("Mendez").get(0);
        Employee jimenez = employeeRepository.findByDtIniBetween(startDate, endDate).get(0);

        System.out.println("***Resultado: " + mendez);
        System.out.println("***Resultado: " + jimenez);
    }

    public void testDevelopers(){
        Developer junior = new Developer();
        junior.setName("Juan");
        junior.setSurname("Mendez");
        junior.setSalary(1000.);
        junior.setDtIni(new Date());
        junior.setCategory(Category.JUNIOR);
        developerRepository.save(junior);


        Developer senior = new Developer();
        senior.setName("Marc");
        senior.setSurname("Sanahuja");
        senior.setSalary(1500.);
        senior.setDtIni(new Date());
        senior.setCategory(Category.SENIOR);
        developerRepository.save(senior);

        Developer architect = new Developer();
        architect.setName("Juan");
        architect.setSurname("Quispe");
        architect.setSalary(3000.);
        architect.setDtIni(new Date());
        architect.setCategory(Category.ARCHITECT);
        developerRepository.save(architect);
    }



}
