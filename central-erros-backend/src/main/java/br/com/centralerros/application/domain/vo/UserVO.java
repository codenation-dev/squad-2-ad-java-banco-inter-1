package br.com.centralerros.application.domain.vo;

import br.com.centralerros.application.domain.enumerables.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private Long id;
    private String name;
    private RoleEnum role;

    @Email
    private String email;
}
