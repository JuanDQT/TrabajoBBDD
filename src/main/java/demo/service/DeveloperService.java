package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 16/06/2015.
 */

//base de datos
@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    public void testDeveloper(){
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

        Developer d1 = new Developer();
        d1.setName("Pedro_D");
        d1.setSurname("Quintana");
        d1.setSalary(3000.);
        d1.setDtIni(new Date());
        d1.setCategory(Category.SENIOR);
        developerRepository.save(d1);

    }
}
