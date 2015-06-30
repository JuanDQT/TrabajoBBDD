package demo.controllers;

import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	private DeveloperRepository developerRepository;

	@RequestMapping(method = POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Developer save(@RequestBody Developer developer) {
		return developerRepository.save(developer);
	}

    @RequestMapping(method = GET)
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while(iterator.hasNext()){
            developers.add(iterator.next());
        }

        return developers;
    }

	//Este cambio simplemente es una prueba  para ver si coge el parámetro  autor del commit a partir de la configuración específica degit del proyecto no la global del usuario
}
