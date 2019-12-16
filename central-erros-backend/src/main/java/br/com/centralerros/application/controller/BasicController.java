package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.utils.Utils;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class BasicController {
    public Utils utils;
    public Long userId;

    Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
}