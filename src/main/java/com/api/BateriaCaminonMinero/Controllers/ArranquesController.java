package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.*;
import com.api.BateriaCaminonMinero.Response.PromedioArranquexMes;
import com.api.BateriaCaminonMinero.Services.ArranquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
    @GetMapping("/promedioxmes/{camionId}")
    public List<PromedioArranquexMes> arranquesxmes(@PathVariable int camionId) {
        //return arranqueService.obtenerPromedioCorrienteUltimoMes(camionId);

        List<Object[]> result = arranqueService.obtenerPromedioCorrienteUltimoMes(camionId);
        List<PromedioArranquexMes> response = new ArrayList<>();

        for (Object[] row : result) {
            Date mes = (Date) row[0];
            Double promedio = (Double) row[1];
            Long contador = (Long) row[2];

            PromedioArranquexMes entry = new PromedioArranquexMes();
            entry.setFecha(mes);
            entry.setPromedio(promedio);
            entry.setContador(contador);
            response.add(entry);
        }

        return response;
    }
    @GetMapping("/promedioxmes2/{camionId}")
    public List<Object[]> arranquesxmes2(@PathVariable int camionId) {
        //return arranqueService.obtenerPromedioCorrienteUltimoMes(camionId);

       return arranqueService.obtenerPromedioCorrienteUltimoMes(camionId);
    }

    @GetMapping("/promedio/{camion}")
    public List<PromedioCorrienteResponse> obtenerPromedioCorrientePorCamion(@PathVariable int camion) {
        List<Object[]> result = arranqueService.PromedioCamion(camion);
        List<PromedioCorrienteResponse> response = new ArrayList<>();

        for (Object[] row : result) {
            int mes = (int) row[0];
            double promedioCorriente = (double) row[1];
            CamionesModel camionesModel = (CamionesModel) row[2];
            EmpresasModel empresasModel = (EmpresasModel) row[3];

            PromedioCorrienteResponse entry = new PromedioCorrienteResponse();
            entry.setMes(mes);
            entry.setPromedioCorriente(promedioCorriente);
            entry.setCamionesModel(camionesModel);
            entry.setEmpresasModel(empresasModel);

            response.add(entry);
        }

        return response;
    }
    @GetMapping("/conteo/{camion}")
    public List<CountResponse> obtenerConteoRegistrosPorCamion(@PathVariable int camion) {
        List<Object[]> result = arranqueService.ConteoRegistrosYear(camion);
        List<CountResponse> response = new ArrayList<>();

        for (Object[] row : result) {
            Integer fecha = (Integer) row[0];
            Long conteo = (Long) row[1];
            CamionesModel camionesModel = (CamionesModel) row[2];

            CountResponse entry = new CountResponse();
            entry.setFecha(fecha);
            entry.setConteo(conteo);
            entry.setCamionesModel(camionesModel);

            response.add(entry);
        }
        return response;
    }
    @GetMapping("/empresaxcamion/{empresa}/{camion}")
    public List<ArranquesModel> ListarArranqueEmpresaxCamion(@PathVariable Long empresa, @PathVariable Long camion){
        return arranqueService.ListarArranqueXEmpresaYxCamion(empresa, camion);
    }

    @PostMapping("/registrarT/{id}")
    public ResponseEntity<ArranquesModel> RegistrarArranqueCond(@RequestBody ArranquesModel arranquesModel, @PathVariable Long id){
        ArranquesModel arranque = arranqueService.RegistrarArranqueSecond(arranquesModel, id);
        if (arranque != null){
            return new ResponseEntity<>(arranque, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ArranquesModel> RegistrarArranque(@RequestBody ArranquesModel arranquesModel){
        ArranquesModel arranque = arranqueService.RegistrarArranque(arranquesModel);
        if (arranque != null){
            return new ResponseEntity<>(arranque, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/registrar")
    public ResponseEntity<ArranquesModel> Registrar(@RequestBody ArranquesModel arranquesModel){
        ArranquesModel arranque = arranqueService.Registar(arranquesModel);
        return new ResponseEntity<>(arranque, HttpStatus.OK);
    }
}
