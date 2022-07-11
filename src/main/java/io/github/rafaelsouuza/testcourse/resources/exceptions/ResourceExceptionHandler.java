package io.github.rafaelsouuza.testcourse.resources.exceptions;

import io.github.rafaelsouuza.testcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        StandardError error = new StandardError();
        HttpStatus statusNotFound = HttpStatus.NOT_FOUND;

        error.setTimestamp(LocalDateTime.now());
        error.setStatus(statusNotFound.value());
        error.setError(ex.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(statusNotFound).body(error);
    }
}
