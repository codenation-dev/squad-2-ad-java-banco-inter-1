package br.com.centralerros.application.domain.entity;


import br.com.centralerros.application.domain.enumerables.CategoryEnum;
import br.com.centralerros.application.domain.enumerables.EnvironmentEnum;
import br.com.centralerros.application.domain.enumerables.LevelEnum;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "source", nullable = false, length = 255)
    private String source;

    @Column(name = "details", nullable = false, length = 255)
    private String details;

    @Column(name = "status")
    private StatusEnum status = StatusEnum.OPEN;

    @Column(name = "environment")
    private EnvironmentEnum environment;

    @Column(name = "level")
    private LevelEnum level;

    @Column(name = "category")
    private CategoryEnum category;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

}
