package br.com.centralerros.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(Throwable cause){
        super(cause);
    }

}
