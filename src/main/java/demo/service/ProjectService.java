package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Project;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    public void testProject(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();
        calendar.set(2015, Calendar.SEPTEMBER, 1);
        Date endDate = calendar.getTime();
        Project project = new Project();
        project.setDescription("PROYECTO DE JAVA");
        project.setStartDate(startDate);
        project.setEndtDate(endDate);

        projectRepository.save(project);

        Project vacio = new Project();
        vacio.setDescription("Projecto vacio");
        vacio.setStartDate(new Date());
        projectRepository.save(vacio);

        Developer developer1 = new Developer();
        developer1.setName("Mario");
        developer1.setSurname("Romero");
        developer1.setSalary(3400.0);
        developer1.setCategory(Category.JUNIOR);
        developer1.setDtIni(new Date());

        developerRepository.save(developer1);

        project.getDevelopers().add(developer1);

        projectRepository.save(project);

    }
}
