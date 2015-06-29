package demo.controllers;

import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by poo2 on 29/06/2015.
 */
@RestController
@RequestMapping("/developers")//ruta de la web on estara el controller.

public class DeveloperController {

    @Autowired//conecta con el repositorio
    private DeveloperRepository developerRepository;

    @RequestMapping(method = POST)//consulta
    @ResponseStatus(HttpStatus.CREATED)//crear
    public Developer save(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @RequestMapping(method = GET)//read
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while (iterator.hasNext()) {
            developers.add(iterator.next());
        }

        return developers;
    }
}
