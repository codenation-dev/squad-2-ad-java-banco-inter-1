package br.com.centralerros.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Email
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime created_at;

    @Column(name = "last_login")
    private LocalDateTime last_login;

    @Column(name = "profile")
    private int profile;

    @ManyToOne
    @JoinColumn(name = "enviroment_id")
    private Enviroment enviroment_id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;


    public User(User user) {
        super();
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
