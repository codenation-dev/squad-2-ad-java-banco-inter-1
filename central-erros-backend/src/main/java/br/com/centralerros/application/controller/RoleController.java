package br.com.centralerros.application.controller;

import br.com.centralerros.application.domain.entity.Role;
import br.com.centralerros.application.domain.vo.RoleVO;
import br.com.centralerros.application.service.RoleService;
import br.com.centralerros.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/role")
public class RoleController extends BasicController {
    @Autowired
    RoleService roleService;

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(
            Utils.listMap(roleService.findAll(), RoleVO.class)
        );
    }
}
