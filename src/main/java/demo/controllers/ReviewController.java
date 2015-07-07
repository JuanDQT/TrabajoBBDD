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

    @RequestMapping(value = "/projects/{idProject}/developers/{idDeveloper}/specialties/{idSpecialty}/review",
                    method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review addRevieew(@PathVariable Long idProject, @PathVariable Long idDeveloper,
                             @PathVariable Long idSpecialty, @RequestBody Review review){

        CheckParameters checkParameters = new CheckParameters(idProject, idDeveloper, idSpecialty).invoke();

        Project project = checkParameters.getProject();
        Developer developer = checkParameters.getDeveloper();
        Specialty specialty = checkParameters.getSpecialty();

        review.setDtIni(new Date());
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpecialty(specialty);

        reviewRepository.save(review);
        return review;
    }

    @RequestMapping(value = "/projects/{idProject}/developers/{idDeveloper}/specialties/{idSpecialty}/review",
            method = RequestMethod.GET)
    public Review getReview(@PathVariable Long idProject, @PathVariable Long idDeveloper,
                            @PathVariable Long idSpecialty){

        CheckParameters checkParameters = new CheckParameters(idProject, idDeveloper, idSpecialty).invoke();

        Project project = checkParameters.getProject();
        Developer developer = checkParameters.getDeveloper();
        Specialty specialty = checkParameters.getSpecialty();

        Review review = reviewRepository.findByProjectIdAndDeveloperIdAndSpecialtyId(project.getId(),
                                                                                    developer.getId(),
                                                                                    specialty.getId());
        return review;

    }

    private class CheckParameters {
        private Long idProject;
        private Long idDeveloper;
        private Long idSpecialty;
        private Project project;
        private Developer developer;
        private Specialty specialty;

        public CheckParameters(Long idProject, Long idDeveloper, Long idSpecialty) {
            this.idProject = idProject;
            this.idDeveloper = idDeveloper;
            this.idSpecialty = idSpecialty;
        }

        public Project getProject() {
            return project;
        }

        public Developer getDeveloper() {
            return developer;
        }

        public Specialty getSpecialty() {
            return specialty;
        }

        public CheckParameters invoke() {
            project = projectRepository.findOne(idProject);
            developer = developerRepository.findOne(idDeveloper);
            specialty = specialtyRepository.findOne(idSpecialty);

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
            return this;
        }
    }
}
