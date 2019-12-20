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
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BasicController {

    @Autowired
    protected UserServiceImpl userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return validadeRetorno(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/id/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return validadeRetorno(userService.findByIdVO(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity findByEmail(@PathVariable("email") String email) {
        return validadeRetorno(userService.findByEmailVO(email));
    }

    @GetMapping("")
    public ResponseEntity findByAll() {
        return validadeRetorno(userService.findAllVO());
    }

    @GetMapping("/details")
    public ResponseEntity getUserDetails() {
        UserVO userDetails = utils.map(utils.getLoggedUser(), UserVO.class);
        return validadeRetorno(userDetails);

    }

    public ResponseEntity<? extends Object> validadeRetorno(Object object) {
        if (object != null) {
            return ResponseEntity.ok(object);
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
