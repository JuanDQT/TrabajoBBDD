package demo.service;

import demo.model.*;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public void testReview(){
        Developer d = new Developer();
        d.setName("Alberto");
        d.setSurname("Projecto");
        d.setSalary(999.0);
        developerRepository.save(d);

        Manager m = new Manager();
        m.setName("jefazo");
        managerRepository.save(m);

        Specialty s = new Specialty();
        s.setName("Malabarista");
        specialtyRepository.save(s);

        Project p = new Project();
        p.setDescription("Proyecto General");
        p.setManager(m);
        p.setStartDate(new Date());
        p.getSpecialities().add(s);
        p.setSpecialities();
        projectRepository.save(p);

        Review r = new Review();
        r.setComment("muy malo");
        r.setDeveloper(d);
        r.setProject(p);
        r.setSpecialty(s);
        reviewRepository.save(r);
    }
}
