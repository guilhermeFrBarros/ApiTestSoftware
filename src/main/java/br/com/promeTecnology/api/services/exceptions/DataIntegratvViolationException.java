package br.com.promeTecnology.api.services.exceptions;

public class DataIntegratvViolationException extends RuntimeException {
    public DataIntegratvViolationException(String message ) {
        super( message );
    }
}
