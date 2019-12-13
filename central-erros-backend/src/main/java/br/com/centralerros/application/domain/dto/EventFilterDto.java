package br.com.centralerros.application.domain.dto;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.enumerables.CategoryEnum;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

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
    private CategoryEnum category;
    private Timestamp createDate;
    private int userId;
}
