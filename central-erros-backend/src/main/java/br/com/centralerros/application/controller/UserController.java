package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    protected UserService userService;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserVO userVO){
        
        User user = convertToUser(userVO);
        return ResponseEntity.ok(userService.save(user)
        );
    }

    private User convertToUser(UserVO userVO){
        return User.builder()
                .email(userVO.getEmail())
                .name(userVO.getName())
                .password(userVO.getPassword())
                .build();
    }



}
