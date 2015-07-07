package demo.service;

import demo.model.*;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */

@Service
@Transactional//sirve para que se inicie una transaccion
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
        d.setSurname("Garcia");
        d.setSalary(999.0);
        d.setDtIni(new Date ());
        developerRepository.save(d);

        Manager m = new Manager();
        m.setName("jefazo");
        managerRepository.save(m);

        Specialty s = new Specialty();
        s.setName("Java");
        specialtyRepository.save(s);

        d.getSpecialties().add(s);
        developerRepository.save(d);

        Project p = new Project();
        p.setDescription("Android");
        p.setManager(m);
        p.setStartDate(new Date());

        p.getSpecialties().add(s);
        p.getDevelopers().add(d);
        projectRepository.save(p);

        Review r = new Review();
        r.setScore(9L);
        r.setComment("Proyecto OK");
        r.setDeveloper(d);
        r.setProject(p);
        r.setSpecialty(s);
        reviewRepository.save(r);
    }
}
