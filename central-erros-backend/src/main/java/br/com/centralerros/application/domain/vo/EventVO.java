package br.com.centralerros.application.domain.vo;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.entity.Level;
import br.com.centralerros.application.domain.entity.Status;
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
    private Environment environment;
    private Level level;
    private Category category;
    private String details;
    private Status status;

}
