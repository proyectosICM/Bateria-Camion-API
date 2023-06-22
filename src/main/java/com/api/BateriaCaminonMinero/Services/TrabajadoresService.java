package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrabajadoresService {
    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    public List<TrabajadoresModel> ListarTrabajadores(){
        return trabajadoresRepository.findAll();
    }

    public Optional<TrabajadoresModel> ListarTrabajadorId(Long id){
        return trabajadoresRepository.findById(id);
    }
    public List<TrabajadoresModel> ListarTrabjadorxEmpT(Long emp){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpT(emp);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setId_emp((Long) resultado[4]);
            empresasxe.setNom_emp((String) resultado[5]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            trabajadoresxe.setEst_tra((Boolean) resultado[6]);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpH( Boolean est, Long emp){
        List<Object[]> resultados = trabajadoresRepository.ListTrabjadorxEmpH(est, emp);
        List<TrabajadoresModel> trabajadorList = new ArrayList<>();

        for (Object[] resultado : resultados){
            TrabajadoresModel trabajadoresxe =  new TrabajadoresModel();
            trabajadoresxe.setId_tra((Long) resultado[0] );
            trabajadoresxe.setNom_tra((String) resultado[1]);
            trabajadoresxe.setApe_tra((String) resultado[2]);
            trabajadoresxe.setDni_tra((String) resultado[3]);
            EmpresasModel empresasxe = new EmpresasModel();
            empresasxe.setId_emp((Long) resultado[4]);
            empresasxe.setNom_emp((String) resultado[5]);
            trabajadoresxe.setEmpresasModel(empresasxe);
            trabajadoresxe.setEst_tra((Boolean) resultado[6]);
            trabajadorList.add(trabajadoresxe);
        }
        return trabajadorList;
    }

    public TrabajadoresModel CrearTrabajador(TrabajadoresModel trabajadoresModel){
        return trabajadoresRepository.save(trabajadoresModel);
    }

    public TrabajadoresModel EditarTrabajador(TrabajadoresModel trabajadoresModel, Long id){
        Optional<TrabajadoresModel> existing = trabajadoresRepository.findById(id);
        if(existing.isPresent()){
            TrabajadoresModel trabajadores = existing.get();
            trabajadores.setNom_tra(trabajadoresModel.getNom_tra());
            trabajadores.setApe_tra(trabajadoresModel.getApe_tra());
            trabajadores.setDni_tra(trabajadoresModel.getDni_tra());
            trabajadores.setEst_tra(trabajadoresModel.getEst_tra());
            trabajadores.setEmpresasModel(trabajadoresModel.getEmpresasModel());
            return trabajadoresRepository.save(trabajadores);
        } else {
            return null;
        }
    }

    public void EliminarTrabajador(Long id){
        trabajadoresRepository.deleteById(id);
    }
}
