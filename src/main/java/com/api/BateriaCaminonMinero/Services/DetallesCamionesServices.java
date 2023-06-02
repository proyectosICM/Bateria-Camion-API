package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Repositories.DetallesCamionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DetallesCamionesServices {
    @Autowired
    DetallesCamionRepository detallesCamionRepository;

    public List<Object[]> getDetallesValores(int camion) {
        return detallesCamionRepository.getDetallesValores(camion);
    }
}
