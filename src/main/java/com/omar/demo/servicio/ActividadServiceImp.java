package com.omar.demo.servicio;

import com.omar.demo.dao.ActividadRepository;
import com.omar.demo.domain.Actividad;
import com.omar.demo.domain.Sesion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActividadServiceImp implements ActividadService {

    @Autowired
    ActividadRepository actividadRepository;

    @Override
    public Actividad localizarPorId(Integer id) {
        return actividadRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Actividad> localizarPorNombre(String nombre) {
        return actividadRepository.findByNombre(nombre);
    }

    @Override
    public List<Actividad> localizarPorSesion(Sesion sesion) {
        return actividadRepository.findBySesion(sesion);
    }
}
