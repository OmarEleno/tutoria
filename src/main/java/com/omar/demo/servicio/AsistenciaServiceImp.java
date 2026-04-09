package com.omar.demo.servicio;

import com.omar.demo.dao.AsistenciaRepository;
import com.omar.demo.domain.Asistencia;
import com.omar.demo.domain.Sesion;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class AsistenciaServiceImp implements AsistenciaService{

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Override
    public Asistencia localizarPorId(Integer id) {
        return asistenciaRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Asistencia> localizarPorSesion(Sesion sesion) {
        return asistenciaRepository.findBySesion(sesion);
    }

    @Override
    public List<Asistencia> localizarPorFecha(LocalDate fecha) {
        return asistenciaRepository.findByFecha(fecha);
    }
}
