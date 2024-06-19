package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.models.*;
import com.api.BateriaCaminonMinero.response.DetalleBateriaYearResponse;
import com.api.BateriaCaminonMinero.services.DetalleBateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/detalles")
public class DetalleBateriasController {
    @Autowired
    DetalleBateriasService detalleBateriasService;
    @GetMapping("/promedioxmes/{bateria}")
    public List<DetalleBateriaYearResponse> arranquesxmes2(@PathVariable Long bateria) {
        List<Object[]> result = detalleBateriasService.PromedioBateria(bateria);
        List<DetalleBateriaYearResponse> response = new ArrayList<>();

        for (Object[] row : result) {
            int fecha = (int) row[0];
            Long contador = (Long) row[1];
            double voltaje = (double) row[2];
            double cargaA = (double) row[3];
            double corriente = (double) row[4];
            double temperatura = (double) row[5];

            DetalleBateriaYearResponse entry = new DetalleBateriaYearResponse();
            entry.setFecha(fecha);
            entry.setContador(contador);
            entry.setVoltaje(voltaje);
            entry.setCargaA(cargaA);
            entry.setCorriente(corriente);
            entry.setTemperatura(temperatura);
            response.add(entry);
        }

        return response;
    }
    @GetMapping("/promediodiaxmes/{bateria}")
    public List<DetalleBateriaYearResponse> arranquesdiaxmes(@PathVariable Long bateria) {
        List<Object[]> result = detalleBateriasService.PromedioBateriaDiaxMes(bateria);
        List<DetalleBateriaYearResponse> response = new ArrayList<>();

        for (Object[] row : result) {
            Date fecha = (Date) row[0];
            Double voltaje = (Double) row[1];
            BigDecimal carga = (BigDecimal) row[2];
            Double corriente = (Double) row[3];
            Double temperatura = (Double) row[4];
            Long contador = (Long) row[5];

            DetalleBateriaYearResponse entry = new DetalleBateriaYearResponse();
            entry.setDia(fecha);
            entry.setVoltaje(voltaje);
            entry.setCarga(carga);
            entry.setCorriente(corriente);
            entry.setTemperatura(temperatura);
            entry.setContador(contador);
            response.add(entry);
        }

        return response;
    }
    @GetMapping("/ultimodia/{bateria}")
    public List<DetalleBateriasModel> UltimoDia(@PathVariable Long bateria){
        return detalleBateriasService.DetallesUltimoDiaBateria(bateria);
    }

    @GetMapping("/promediodiaxmes2/{bateria}")
    public List<Object[]> arranquesdiaxmes2(@PathVariable Long bateria) {
        return detalleBateriasService.PromedioBateriaDiaxMes(bateria);

    }
    @GetMapping("/promedioxmes2/{bateria}")
    public List<Object[]> arranquesxmes3(@PathVariable Long bateria) {
        return detalleBateriasService.PromedioBateria(bateria);
    }

    @GetMapping
    public List<DetalleBateriasModel> GetAll(){
        return detalleBateriasService.ListarDetalles();
    }

    @GetMapping("bateriaxdetalle/{bateria}")
    public List<DetalleBateriasModel> GetBatxDet(@PathVariable("bateria") Long bateria){
        return detalleBateriasService.ListarBateriaxDetalle(bateria);
    }

    @GetMapping("dia/{id}")
    public List<DetalleBateriasModel> obtenerRegistrosPorDia(@PathVariable Long id) {
        return detalleBateriasService.ListarDetallexDia(id);
    }

    @GetMapping("d/{dia}")
    public List<DetalleBateriasModel> obtenerRegistrosD(@PathVariable Date dia) {
        return detalleBateriasService.ListarDetallexD(dia);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleBateriasModel> buscarPorId(@PathVariable Long id){
        Optional<DetalleBateriasModel> data = detalleBateriasService.ListarporId(id);
        if(data.isPresent()){
            return new ResponseEntity<>(data.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("diab/{id}")
    public ResponseEntity<DetalleBateriasModel> ListarDBateriaxDia(@PathVariable Long id, @RequestBody DetalleBateriasModel detalleBateriasModel ) {
        DetalleBateriasModel deta = detalleBateriasService.ListarDBateriaxDia(id, detalleBateriasModel);
        return new ResponseEntity<>(deta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetalleBateriasModel>Crear(@RequestBody DetalleBateriasModel detalleBateriasModel){
        DetalleBateriasModel cdetalle = detalleBateriasService.CrearR(detalleBateriasModel);
        return new ResponseEntity<>(cdetalle, HttpStatus.OK);
    }
}
