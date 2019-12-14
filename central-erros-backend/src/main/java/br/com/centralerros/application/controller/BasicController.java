package br.com.centralerros.application.controller;

import br.com.centralerros.application.utils.Utils;
import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class BasicController {
    public Utils utils;
}