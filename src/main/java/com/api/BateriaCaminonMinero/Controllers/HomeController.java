package com.api.BateriaCaminonMinero.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String Home(){
        return "Hola mundo";
    }

    @GetMapping("/hola")
    public String Hola2(){
        return "Hola 2 mundo";
    }
}
