package br.com.centralerros.application.domain.entity;


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

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime created_at;

    @ManyToOne
    @JoinColumn(name = "environment_id")
    private Environment environment_id;

    @OneToOne
    @JoinColumn(name = "level_id")
    private Level level_id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    @Column(name = "details", nullable = false, length = 255)
    private String details;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Category status_id;




}
