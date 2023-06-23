package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Services.BateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/baterias")
public class BateriaController {
    @Autowired
    BateriaService bateriaService;

    @GetMapping("/camiones/{id}")
    public List<BateriasModels> buscarBateriasPorCamionesModel(@PathVariable Long id) {
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId_cam(id);
        return bateriaService.buscarBateriasPorCamionesModel(camionesModel);
    }
}
