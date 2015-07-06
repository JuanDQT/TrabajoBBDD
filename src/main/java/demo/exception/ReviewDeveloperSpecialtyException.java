package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class ReviewDeveloperSpecialtyException extends RuntimeException {
    public ReviewDeveloperSpecialtyException(Long developerId, Long specialityId){
        super("Especialidad id: " + specialityId + " y Developer id: "+ developerId + " no estan vinculados.");
    }
}

