package br.com.centralerros.application.domain.vo;

import br.com.centralerros.application.domain.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO {
    private Long id;
    private String name;
    private Application application;

}
