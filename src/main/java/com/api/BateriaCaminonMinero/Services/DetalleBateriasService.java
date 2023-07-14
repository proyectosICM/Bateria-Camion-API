    package com.api.BateriaCaminonMinero.Services;

    import com.api.BateriaCaminonMinero.Models.BateriasModels;
    import com.api.BateriaCaminonMinero.Models.CamionesModel;
    import com.api.BateriaCaminonMinero.Models.DetalleBateriasModel;
    import com.api.BateriaCaminonMinero.Repositories.DetalleBateriasRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.sql.Time;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class DetalleBateriasService {
        @Autowired
        DetalleBateriasRepository detalleBateriasRepository;

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

        public List<DetalleBateriasModel> ListarBateriaxDetalle(Long id){
            BateriasModels bateriasModels = new BateriasModels();
            bateriasModels.setId_bat(id);
            return detalleBateriasRepository.findByBateriasModels(bateriasModels);
        }

        public List<DetalleBateriasModel> ListarDetallexDia(Long id){
            Optional<DetalleBateriasModel> detab = detalleBateriasRepository.findById(id);
            Date dia = detab.get().getDia();
            return detalleBateriasRepository.findByIdAndDia(id,dia);
        }

        public List<DetalleBateriasModel> ListarDetallexD(Date dia){
            return detalleBateriasRepository.findByDia(dia);
        }

        public DetalleBateriasModel ListarDBateriaxDia(Long id, DetalleBateriasModel detalleBateriasModel){
            Date dia = detalleBateriasModel.getDia();
            return detalleBateriasRepository.findByBateriasModelsAndDia(id,dia);
        }
    }
