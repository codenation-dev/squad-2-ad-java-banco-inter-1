package br.com.centralerros.application.exception;

public class IncompleteFieldsException extends RuntimeException {
    public IncompleteFieldsException(String message) {
        super(message);
    }
}
