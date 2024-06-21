package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.models.*;
import com.api.BateriaCaminonMinero.response.DetalleBateriaYearResponse;
import com.api.BateriaCaminonMinero.services.DetalleBateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("api/detalles")
public class DetalleBateriasController {
    @Autowired
    private DetalleBateriasService detalleBateriasService;

    @GetMapping("/bateria/{id}")
    public List<DetalleBateriasModel> findByBateriasModelId(@PathVariable("id") Long id){
        return detalleBateriasService.findByBateriasModelId(id);
    }

    @GetMapping("/bateria-page/{id}")
    public Page<DetalleBateriasModel> findByBateriasModelId(@PathVariable("id") Long id,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return detalleBateriasService.findByBateriasModelId(id, pageable);
    }

    @GetMapping("/promedios-horarios/{bateriaId}")
    public ResponseEntity<List<Map<String, Object>>> getHourlyAveragesForToday(@PathVariable Long bateriaId) {
        List<Map<String, Object>> result = detalleBateriasService.getHourlyAveragesForToday(bateriaId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/promedios-diarios/{bateriaId}")
    public ResponseEntity<List<Map<String, Object>>> getDailyAverages(@PathVariable Long bateriaId) {
        List<Map<String, Object>> promediosDiarios = detalleBateriasService.getDailyAverages(bateriaId);
        return ResponseEntity.ok(promediosDiarios);
    }

    /** **/
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


/*
    @GetMapping("dia/{id}")
    public List<DetalleBateriasModel> obtenerRegistrosPorDia(@PathVariable Long id) {
        return detalleBateriasService.ListarDetallexDia(id);
    }
*/
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
/*
    @PostMapping("diab/{id}")
    public ResponseEntity<DetalleBateriasModel> ListarDBateriaxDia(@PathVariable Long id, @RequestBody DetalleBateriasModel detalleBateriasModel ) {
        DetalleBateriasModel deta = detalleBateriasService.ListarDBateriaxDia(id, detalleBateriasModel);
        return new ResponseEntity<>(deta, HttpStatus.OK);
    }
*/
    @PostMapping
    public ResponseEntity<DetalleBateriasModel>Crear(@RequestBody DetalleBateriasModel detalleBateriasModel){
        DetalleBateriasModel cdetalle = detalleBateriasService.CrearR(detalleBateriasModel);
        return new ResponseEntity<>(cdetalle, HttpStatus.CREATED);
    }
}
