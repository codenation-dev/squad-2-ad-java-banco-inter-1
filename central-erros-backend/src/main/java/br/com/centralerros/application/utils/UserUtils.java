package br.com.centralerros.application.utils;

import br.com.centralerros.application.domain.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;

public class UserUtils {
    public static User getLoggedUser(){
        User user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null
                && authentication.getPrincipal() != null
                && authentication.getPrincipal() instanceof User) {
            user = (User)authentication.getPrincipal();
        }
        return user;
    }
}
