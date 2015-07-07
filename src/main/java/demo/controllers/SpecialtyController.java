package demo.controllers;

import demo.exception.ProjectException;
import demo.model.Specialty;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by poo2 on 29/06/2015.
 */
@RestController
@RequestMapping("/specialties")
public class SpecialtyController {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    /*CONSEUGIR TODOS LAS SPECIALTIES*/
    @RequestMapping(method = RequestMethod.GET)
    public List<Specialty> findAll() {
        List<Specialty> specialties = new ArrayList<Specialty>();
        Iterator<Specialty> iterator = specialtyRepository.findAll().iterator();

        while (iterator.hasNext()) {
            specialties.add(iterator.next());
        }
        return specialties;
    }

    //CONSEUGIR EL ID DE UN MANAGER
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Specialty getById(@PathVariable Long id) {
        Specialty specialty = specialtyRepository.findOne(id);

        if (specialty == null)
            throw new ProjectException(id);

        return specialty;
    }
/*
    //BORRAR UN PROYECTO
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Project deleteById(@PathVariable Long id) {
        Project project = projectRepository.findOne(id);
        if (project == null)
            throw new ProjectException(id);

        projectRepository.delete(id);
        return project;
    }

    //MODIFICAR UN PROJECT
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Project updateById(@PathVariable Long id, @RequestBody Project newProject) {
        Project project = projectRepository.findOne(id);
        if (project == null)
            throw new ProjectException(id);

        newProject = projectRepository.save(newProject);
        return newProject;
    }

    //ASIGNAR UN MANAGER A UN PROYECT
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
    //CONSEGUIR UN MANAGER A PARTIR DE UNA ID DE UN PROYECTOO
    @RequestMapping(value = "/{idProject}/manager", method = GET)
    public Manager getManager(@PathVariable Long idProject) {

        Project project = projectRepository.findOne(idProject);

        if (project == null)
            throw new ProjectException(idProject);

        return project.getManager();
    }

    //
        //ASIGNAR UN DEVELOPER A UN PROYECT
    @RequestMapping(value = "/{idProject}/developers/{idDeveloper}", method = POST)
    public Project addDeveloper(@PathVariable Long idProject, @PathVariable Long idDeveloper) {
        Project project = projectRepository.findOne(idProject);
        if (project == null)
            throw new ProjectException(idProject);///

        Developer developer = developerRepository.findOne(idDeveloper);
        if (developer == null)
            throw new ProjectException(idProject);
        //project.setDevelopers().add;
        //NO FUNCIONA
        project.getDevelopers().add(developer);
        projectRepository.save(project);
        return project;
    }

    //CONSEGUIR UN O MAS DEVELOPER A PARTIR DE UNA ID DE UN PROYECTOO
    @RequestMapping(value = "/{idProject}/developers", method = GET)
    public Set<Developer> getDevelopers(@PathVariable Long idProject) {
        //Developer developer = developerRepository.findOne();//CONSEGUIRIA LOS DEVELOPERS

        Project project = projectRepository.findOne(idProject);

        if (project == null)
            throw new ProjectException(idProject);//

        return project.getDevelopers();
        //COMO CONSEGUIR LA LISTA DE LOS DEVELOPERS ASOCIADOS AL PROYECTO?
        //return null;//project.getDevelopers().addAll();
    }*/
}