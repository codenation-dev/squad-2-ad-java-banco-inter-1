package br.com.centralerros.application.domain.vo;

import br.com.centralerros.application.domain.enumerables.CategoryEnum;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventVO {
    private String name;
    private String description;
    private String source;

    private String details;
    private LevelEnum level;
    private EnvironmentEnum environment;
    private CategoryEnum category;
    private StatusEnum status;
}
