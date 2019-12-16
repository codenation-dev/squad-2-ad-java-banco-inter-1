package br.com.centralerros.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException(String message, Throwable cause){
        super(message, cause);
    }

    public NotAuthorizedException(String message){
        super(message);
    }

    public NotAuthorizedException(Throwable cause){
        super(cause);
    }
}
