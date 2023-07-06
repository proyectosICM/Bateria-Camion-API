package com.api.BateriaCaminonMinero.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {
    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('CONDUCTOR')")
    public String accessAdmin(){
        return "Hola, has accedido con un rol de ADMIN";
    }

    @GetMapping("/accessUser")
    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PreAuthorize("hasRole('SUPERVISOR')")
    public String accessUser(){
        return "Hola, has accedido con un rol de USER";
    }

    @GetMapping("/accessInvited")
    @PreAuthorize("hasRole('INVITED')")
    public String accessInvited(){
        return "Hola, has acceddo con un rol de INVITED";
    }
}
