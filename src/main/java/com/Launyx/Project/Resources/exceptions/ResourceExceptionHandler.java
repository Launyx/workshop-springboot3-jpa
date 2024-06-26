package com.Launyx.Project.Resources.exceptions;

import com.Launyx.Project.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

// Annotation para interceptar as exceções que acontecerem para que este objeto possa executar um possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

    /*
        Annotation para que o método seja capaz de interceptar a requisição que resultou uma exceção,
        para que ela "caia" aqui e receba o tratamento do método
     */

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
