package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.ArranquesModel;
import com.api.BateriaCaminonMinero.Services.ArranquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/arranque")
public class ArranquesController {
    @Autowired
    ArranquesService arranqueService;

    @GetMapping
    public List<ArranquesModel> ListarArranques(){
        return arranqueService.ListarArranques();
    }

    @GetMapping("/xcamion/{id}")
    public List<ArranquesModel> ListarArranquexCamion(@PathVariable Long id){
        return arranqueService.ListarArranquexCamion(id);
    }

    @GetMapping("/empresaxcamion/{empresa}/{camion}")
    public List<ArranquesModel> ListarArranqueEmpresaxCamion(@PathVariable Long empresa, @PathVariable Long camion){
        return arranqueService.ListarArranqueXEmpresaYxCamion(empresa, camion);
    }
}
