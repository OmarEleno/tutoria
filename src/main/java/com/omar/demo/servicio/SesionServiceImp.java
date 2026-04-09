package com.omar.demo.servicio;

import com.omar.demo.dao.SesionRepository;
import com.omar.demo.domain.Grupo;
import com.omar.demo.domain.Sesion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SesionServiceImp implements SesionService {

    @Autowired
    SesionRepository sesionRepository;

    @Override
    public Sesion localizarPorId(Integer id) {
        return sesionRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Sesion> localizarPorGrupo(Grupo grupo) {
        return sesionRepository.findByGrupo(grupo);
    }
}
