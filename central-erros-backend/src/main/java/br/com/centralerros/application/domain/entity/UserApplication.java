package br.com.centralerros.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user_application")
public class UserApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToMany
    @JoinColumn(name = "application_id")
    private Application application_id;


}
