package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BasicController{

    @Autowired
    protected UserServiceImpl userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user){
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.save(user));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity findByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(userService.findByEmailVO(email));
    }

    @GetMapping("")

    public ResponseEntity findByAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/details")
    public ResponseEntity getUserDetails(){
        UserVO userDetails = utils.map(utils.getLoggedUser(), UserVO.class);
        return ResponseEntity.ok(userDetails);

    }
}
