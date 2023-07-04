package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Repositories.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresasService {
    @Autowired
    EmpresasRepository empresasRepository;

    public List<EmpresasModel> ListarEmpresas(){
        return empresasRepository.findAll();
    }
    public List<EmpresasModel> ListarEmpresasH(boolean est){
        return empresasRepository.findByEstado(est);
    }

    public Optional<EmpresasModel> ListarEmpresaId(Long id){
        return empresasRepository.findById(id);
    }

    public EmpresasModel CrearEmpresa(EmpresasModel empresasModel){
        return empresasRepository.save(empresasModel);
    }

    public EmpresasModel EditarEmpresa(EmpresasModel empresasModel, Long id){
        Optional<EmpresasModel> existing = empresasRepository.findById(id);
        if (existing.isPresent()){
            EmpresasModel empresa = existing.get();
            empresa.setNom_emp(empresasModel.getNom_emp());
            empresa.setEstado(empresasModel.getEstado());
            return empresasRepository.save(empresa);
        } else {
            return null;
        }
    }

    public void EliminarEmpresa(Long id){
        empresasRepository.deleteById(id);
    }
}
