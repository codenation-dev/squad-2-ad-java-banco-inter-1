package br.com.centralerros.application.domain.dto;

import br.com.centralerros.application.domain.entity.Application;
import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventFilterDto extends BasicFilterDto {
    private Long id;
    private String description;
    private String source;
    private String details;
    private StatusEnum status;
    private EnvironmentEnum environment;
    private LevelEnum level;
    private Category category;
    private Application application;
    private LocalDateTime createDateStart;
    private LocalDateTime createDateEnd;
    private Long userId;
}
