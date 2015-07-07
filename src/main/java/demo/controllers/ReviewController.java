package demo.controllers;

import demo.exception.*;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Specialty;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */
@RestController
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(value = "/projects/{idProject}/developers/{idDeveloper}/specialties/{idSpecialty}/review")
    @ResponseStatus(HttpStatus.CREATED)
    public Review addRevieew(@PathVariable Long idProject, @PathVariable Long idDeveloper, @PathVariable Long idSpecialty, @RequestBody Review review){

        Project project = projectRepository.findOne(idProject);
        Developer developer = developerRepository.findOne(idDeveloper);
        Specialty specialty = specialtyRepository.findOne(idSpecialty);

        if (project == null)
            throw new ProjectException(idProject);

        if (developer == null)
            throw new DeveloperException(idDeveloper);

        if (developer == null)
            throw new SpecialtyException(idSpecialty);

        if(!developer.getProjects().contains(project))
            throw new ReviewDeveloperProjectException(idProject,idDeveloper);

        if(!project.getSpecialties().contains(specialty))
            throw new ReviewProjectSpecialtyException(idProject,idSpecialty);

        if(!developer.getSpecialties().contains(specialty))
            throw new ReviewDeveloperSpecialtyException(idDeveloper, idSpecialty);

        review.setDtIni(new Date());
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpecialty(specialty);

        reviewRepository.save(review);
        return review;
    }
}
