package demo.service;

import demo.model.Employee;
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

    public void testEmployes(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY,1);

        Date startDate = calendar.getTime();

        calendar.set(2015, Calendar.MARCH,4);
        Date endDate = calendar.getTime();

        calendar.set(2015, Calendar.JULY,24);
        Date dateIncorporation = calendar.getTime();

        Employee employee = new Employee();
        employee.setName("Carlos");
        employee.setSurname("Mendez");
        employee.setSalary(1000.0);
        employee.setDtIni(dateIncorporation);
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("Cesar");
        employee2.setSurname("Jimenez");
        employee2.setSalary(100.0);
        employee2.setDtIni(new Date());
        employeeRepository.save(employee2);

        //BUSQUEDAS//
        //Employee mendez = employeeRepository.findBySurname("Mendez").get(0);
        //Employee jimenez = employeeRepository.findByDtIniBetween(startDate, endDate).get(0);

        //System.out.println("***Resultado: " + mendez);
        //System.out.println("***Resultado: " + jimenez);
    }
}
