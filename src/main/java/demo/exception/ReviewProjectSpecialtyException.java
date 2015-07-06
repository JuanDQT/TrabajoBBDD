package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class ReviewProjectSpecialtyException extends RuntimeException {
    public ReviewProjectSpecialtyException(Long projecteId, Long specialityId){
        super("Especialidad id: " + specialityId + " y Projecte id: "+ projecteId + " no estan vinculados.");
    }
}
