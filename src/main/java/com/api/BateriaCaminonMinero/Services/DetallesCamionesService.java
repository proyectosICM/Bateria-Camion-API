package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Repositories.DetallesCamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesCamionesService {
    @Autowired
    DetallesCamionRepository detallesCamionRepository;

    public List<Object[]> getDetallesValores(int camion) {
        return detallesCamionRepository.getDetallesValores(camion);
    }
}
