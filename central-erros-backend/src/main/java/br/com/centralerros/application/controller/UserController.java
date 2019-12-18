package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.User;
import br.com.centralerros.application.domain.vo.UserVO;
import br.com.centralerros.application.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BasicController{

    @Autowired
    protected UserServiceImpl userService;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserVO userVO){
        return ResponseEntity.ok(
                utils.map(userService.save(utils.map(userVO, User.class)), UserVO.class)
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("")
    public ResponseEntity findByAll(){
        return ResponseEntity.ok(userService.findAll());
    }


}
