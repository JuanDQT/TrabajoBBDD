package demo.controllers;

import demo.exception.ProjectException;
import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
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
 * Created by poo2 on 29/06/2015.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ManagerRepository managerRepository;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project save(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    /*CONSEUGIR TODOS LOS PROYECTOS*/
    @RequestMapping(method = RequestMethod.GET)
    public List<Project> findAll() {
        List<Project> projects = new ArrayList<Project>();
        Iterator<Project> iterator = projectRepository.findAll().iterator();

        while (iterator.hasNext()) {
            projects.add(iterator.next());
        }

        return projects;
    }

    /*CONSEUGIR EL ID DE UN MANAGER*/
    @RequestMapping(value = "/{id}", method = GET)
    public Project getById(@PathVariable Long id) {
        Project project = projectRepository.findOne(id);

        if (project == null)
            throw new ProjectException(id);

        return project;
    }

    /*BORRAR UN PROYECTO*/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Project deleteById(@PathVariable Long id) {
        Project project = projectRepository.findOne(id);
        if (project == null)
            throw new ProjectException(id);

        projectRepository.delete(id);
        return project;
    }

    /*MODIFICAR UN PROJECT*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Project updateById(@PathVariable Long id, @RequestBody Project newProject) {
        Project project = projectRepository.findOne(id);
        if (project == null)
            throw new ProjectException(id);

        newProject = projectRepository.save(newProject);
        return newProject;
    }

    /*ASIGNAR UN MANAGER A UN PROYECT*/
    @RequestMapping(value = "/{idProject}/manager/{idManager}", method = POST)
    public Project addManager(@PathVariable Long idProject, @PathVariable Long idManager) {
        Project project = projectRepository.findOne(idProject);
        if (project == null)
            throw new ProjectException(idProject);

        Manager manager = managerRepository.findOne(idManager);
        if (manager == null)
            throw new ProjectException(idProject);
        project.setManager(manager);
        projectRepository.save(project);
        return project;
    }
    /*CONSEGUIR UN MANAGER A PARTIR DE UNA ID DE UN PROYECTO*/
    @RequestMapping(value = "/{idProject}/manager", method = GET)
    public Manager getManager(@PathVariable Long idProject) {

        Project project = projectRepository.findOne(idProject);

        if (project == null)
            throw new ProjectException(idProject);

        return project.getManager();
    }

}