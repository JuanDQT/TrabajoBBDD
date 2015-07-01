package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 30/06/2015.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)//devuelve el error 404 en lugar del 500
public class ManagerException extends RuntimeException{
        public ManagerException(Long id){
            super("Manager id: " + id + " no existe.");
        }
}
