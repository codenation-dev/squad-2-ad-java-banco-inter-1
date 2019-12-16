package br.com.centralerros.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message, Throwable cause){
        super(message, cause);
    }

    public InternalServerErrorException(String message){
        super(message);
    }

    public InternalServerErrorException(Throwable cause){
        super(cause);
    }
}
