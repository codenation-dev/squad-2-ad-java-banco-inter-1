package br.com.centralerros.application.exception;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDto {
    private String title;
    private int statusCode;
    private String message;
    private LocalDateTime date;
}
