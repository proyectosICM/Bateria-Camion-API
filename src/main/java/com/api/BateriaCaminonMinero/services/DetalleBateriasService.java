    package com.api.BateriaCaminonMinero.services;

    import com.api.BateriaCaminonMinero.models.DetalleBateriasModel;
    import com.api.BateriaCaminonMinero.repositories.DetalleBateriasRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.stereotype.Service;

    import java.util.*;

    @Service
    public class DetalleBateriasService {
        @Autowired
        private DetalleBateriasRepository detalleBateriasRepository;

        public List<DetalleBateriasModel> findByBateriasModelId(Long bateriaId){
            return detalleBateriasRepository.findByBateriasModelIdOrderByDiaDescHoraDesc(bateriaId);
        }

        public Page<DetalleBateriasModel> findByBateriasModelId(Long bateriaId, Pageable pageable){
            return detalleBateriasRepository.findByBateriasModelIdOrderByDiaDescHoraDesc(bateriaId, pageable);
        }

        public List<Map<String, Object>> getHourlyAveragesForToday(Long bateriaId) {
            List<Object[]> results = detalleBateriasRepository.findHourlyAveragesForToday(bateriaId);

            // Convertir los resultados en una lista de mapas
            List<Map<String, Object>> formattedResults = new ArrayList<>();
            for (Object[] result : results) {
                Map<String, Object> map = new HashMap<>();
                map.put("hora", result[0]);
                map.put("voltajePromedio", result[1]);
                map.put("corrientePromedio", result[2]);
                map.put("cargaPromedio", result[3]);
                map.put("temperaturaPromedio", result[4]);
                formattedResults.add(map);
            }
            return formattedResults;
        }

        public List<Map<String, Object>> getDailyAverages(Long bateriaId) {
            List<Object[]> results = detalleBateriasRepository.findDailyAverages(bateriaId);

            // Convertir los resultados en una lista de mapas
            List<Map<String, Object>> formattedResults = new ArrayList<>();
            for (Object[] result : results) {
                Map<String, Object> map = new HashMap<>();
                map.put("dia", result[0]);
                map.put("voltajePromedio", result[1]);
                map.put("corrientePromedio", result[2]);
                map.put("cargaPromedio", result[3]);
                map.put("temperaturaPromedio", result[4]);
                formattedResults.add(map);
            }
            return formattedResults;
        }

        /** **/
        public List<DetalleBateriasModel> DetallesUltimoDiaBateria(Long bateria){
            //List<DetalleBateriasModel> result = detalleBateriasRepository.DetallesUltimoDiaPorBateria(bateria);
            return detalleBateriasRepository.DetallesUltimoDiaPorBateria(bateria);
        }

        public List<Object[]> PromedioBateria(Long bateria){
            return detalleBateriasRepository.PromediosxBateria(bateria);
        }
        public List<Object[]> PromedioBateriaDiaxMes(Long bateria){
            return detalleBateriasRepository.PromedioDetalleDiaxMes(bateria);
        }

        public List<DetalleBateriasModel> ListarDetalles(){
            return detalleBateriasRepository.findAll();
        }


/*
        public List<DetalleBateriasModel> ListarDetallexDia(Long id){
            Optional<DetalleBateriasModel> detab = detalleBateriasRepository.findById(id);
            Date dia = detab.get().getDia();
            return detalleBateriasRepository.findByIdAndDia(id,dia);
        }
*/
        public List<DetalleBateriasModel> ListarDetallexD(Date dia){
            return detalleBateriasRepository.findByDia(dia);
        }
/*
        public DetalleBateriasModel ListarDBateriaxDia(Long id, DetalleBateriasModel detalleBateriasModel){
            Date dia = detalleBateriasModel.getDia();
            return detalleBateriasRepository.findByBateriasModelsAndDia(id,dia);
        }
*/
        public Optional<DetalleBateriasModel> ListarporId(Long id){
            return detalleBateriasRepository.findById(id);
        }

        public DetalleBateriasModel CrearR(DetalleBateriasModel detalleBateriasModel){
            return detalleBateriasRepository.save(detalleBateriasModel);
        }
    }
