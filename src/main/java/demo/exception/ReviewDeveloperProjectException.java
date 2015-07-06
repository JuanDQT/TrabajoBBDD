package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class ReviewDeveloperProjectException extends RuntimeException {
    public ReviewDeveloperProjectException(Long projecteId, Long developerId){
        super("Project id: " + projecteId + " y Developer id: "+ developerId + " no estan vinculados.");
    }
}