package br.com.centralerros.application.exception;

public class NullObjectException extends RuntimeException {
    public NullObjectException(String message) {
        super(message);
    }
}