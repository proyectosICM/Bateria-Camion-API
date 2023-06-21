package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Services.CamionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/camiones")
public class CamionesController {
    @Autowired
    CamionesService camionesService;

    @GetMapping
    public List<CamionesModel> Getall(){
        return camionesService.ListarCamiones();
    }


}
