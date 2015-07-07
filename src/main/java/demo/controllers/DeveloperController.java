package demo.controllers;

import demo.exception.DeveloperException;
import demo.exception.ProjectException;
import demo.model.Developer;
import demo.model.Project;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created by poo2 on 29/06/2015..
 */
@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @RequestMapping(method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while (iterator.hasNext()) {
            developers.add(iterator.next());
        }

        return developers;
    }

    @RequestMapping(value= "/{id}", method = GET)
    public Developer getById(@PathVariable Long id) {
        Developer developer = developerRepository.findOne(id);

        if (developer == null)
            throw new DeveloperException(id);

        return developer;
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
         public Developer deleteById(@PathVariable Long id) {
        Developer developer = developerRepository.findOne(id);

        if (developer == null)
            throw new DeveloperException(id);

        developerRepository.delete(id);
        return developer;
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
    public Developer updateById(@PathVariable Long id, @RequestBody Developer newDeveloper) {
        Developer developer = developerRepository.findOne(id);

        if (developer == null)
            throw new DeveloperException(id);

        newDeveloper = developerRepository.save(newDeveloper);
        return newDeveloper;
    }

    //

    //ASIGNAR UN DEVELOPER A UN PROYECT

    @RequestMapping(value = "/{idProject}/developer/{idDeveloper}", method = POST)
    public Project addDeveloper(@PathVariable Long idProject, @PathVariable Long idDeveloper) {
        Project project = projectRepository.findOne(idProject);
        if (project == null)
            throw new ProjectException(idProject);///

        Developer developer = developerRepository.findOne(idDeveloper);
        if (developer == null)
            throw new ProjectException(idProject);

        project.getDevelopers().add(developer);
        projectRepository.save(project);
        return project;
    }


    //CONSEGUIR UN O MAS DEVELOPER A PARTIR DE UNA ID DE UN PROYECTOO
    /*
    @RequestMapping(value = "/{idProject}/developer", method = GET)
    public Developer getDeveloper(@PathVariable Long idProject) {
        //Developer developer = developerRepository.findOne();//CONSEGUIRIA LOS DEVELOPERS

        Project project = projectRepository.findOne(idProject);

        if (project == null)
            throw new ProjectException(idProject);//

        return project.getManager();
        /*COMO CONSEGUIR LA LISTA DE LOS DEVELOPERS ASOCIADOS AL PROYECTO?
        return null;//project.getDevelopers().addAll();
    }*/
}