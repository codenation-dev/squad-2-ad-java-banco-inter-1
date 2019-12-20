package br.com.centralerros.application.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestReponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Não foi possível resolver a solicitação com os parâmetros informados!";
        return handleExceptionInternal(ex,
                getBodyOfResponse(
                        ex,
                        request,
                        HttpStatus.CONFLICT,
                        "Não foi possível resolver a solicitação com os parâmetros informados!"),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFount(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                getBodyOfResponse(
                        ex,
                        request,
                        HttpStatus.NOT_FOUND,
                        "O recurso procurado não foi encontrado!"),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {NotAuthorizedException.class})
    protected ResponseEntity<Object> handleNotAuthorized(
            RuntimeException ex,
            WebRequest request) {
        return handleExceptionInternal(ex,
                getBodyOfResponse(
                        ex,
                        request,
                        HttpStatus.UNAUTHORIZED,
                        "Você não está autorizado a executar a operação!"),
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler(value = {HttpServerErrorException.InternalServerError.class, NullPointerException.class})
    protected ResponseEntity<Object> handleInternalServerError(
            RuntimeException ex,
            WebRequest request) {
        return handleExceptionInternal(ex,
                    getBodyOfResponse(
                    ex,
                    request,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Oops! Houve um problema ao processar sua solicitação!"),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {InternalServerErrorException.class})
    protected ResponseEntity<Object> handleInternalServerErrorException(
            RuntimeException ex,
            WebRequest request) {
        return handleExceptionInternal(ex,
                getBodyOfResponse(
                    ex,
                    request,
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Oops! Houve um problema ao processar sua solicitação!"),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {InvalidFormatException.class})
    protected ResponseEntity<Object> handleInvalidFormatException(RuntimeException ex,WebRequest request){
        return handleExceptionInternal(ex,
                getBodyOfResponse(
                        ex,
                        request,
                        HttpStatus.BAD_REQUEST,
                        "Não foi possível converter o valor enviado!"),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private ExceptionDto getBodyOfResponse(
            RuntimeException ex,
            WebRequest request,
            HttpStatus status,
            String titulo){
        return ExceptionDto.builder()
                .date(LocalDateTime.now())
                .message(ex.getMessage() + "\nDescription:" + request.getDescription(true))
                .statusCode(status.value())
                .title(titulo)
                .build();
    }
}
