package br.com.centralerros.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

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

    public User(User user) {
        super();
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
