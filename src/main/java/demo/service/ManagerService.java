package demo.service;

import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 16/06/2015.
 */

//base de datos
@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public void testManager(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.JANUARY,1);
        Date startDate = calendar.getTime();

        calendar.set(2015, Calendar.MARCH,1);
        Date endDate = calendar.getTime();

        calendar.set(2015, Calendar.FEBRUARY,1);
        Date dateIncorporation = calendar.getTime();

        Manager manager = new Manager();
        manager.setName("Jaime_Manager");
        manager.setSurname("Herrero");
        manager.setSalary(1000.0);
        manager.setDtIni(new Date());
        manager.setDtIni(dateIncorporation);

        managerRepository.save(manager);

        Project p = new Project();
        p.setDescription("Proyecto PUE");
        p.setEndtDate(new Date(2015,12,28));
        p.setStartDate(new Date());
        projectRepository.save(p);
        p.setManager(manager);
        projectRepository.save(p);

        //
        calendar.set(2007,Calendar.JULY,24);
        Date md1 = calendar.getTime();
        Manager m1 = new Manager();
        m1.setName("Ken");
        m1.setSurname("Levine");
        m1.setSalary(2999.);
        m1.setDtIni(md1);
        
    }
}
