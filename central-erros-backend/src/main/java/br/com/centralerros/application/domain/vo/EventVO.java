package br.com.centralerros.application.domain.vo;

import br.com.centralerros.application.domain.entity.Category;
import br.com.centralerros.application.domain.entity.Environment;
import br.com.centralerros.application.domain.entity.Level;
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
    private Environment environment_id;
    private Level level_id;
    private Category category_id;
    private String details;
    private Category status_id;

}
