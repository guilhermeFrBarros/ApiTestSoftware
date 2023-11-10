package br.com.promeTecnology.api.repositories.exceptions;

import br.com.promeTecnology.api.services.exceptions.DataIntegratvViolationException;
import br.com.promeTecnology.api.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler( ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        var error =  new  StandardError( OffsetDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(),
                request.getRequestURI() );
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( error );
    }
    @ExceptionHandler( DataIntegratvViolationException.class)
    public ResponseEntity<StandardError> DataIntegratvViolation(DataIntegratvViolationException ex, HttpServletRequest request) {
        var error =  new  StandardError( OffsetDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
                request.getRequestURI() );
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( error );
    }
}
