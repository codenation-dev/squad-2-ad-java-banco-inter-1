package br.com.centralerros.application.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicFilterDto {
    public String sort;
    public int page;
    public int pageSize;
}
