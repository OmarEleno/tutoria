package com.omar.demo.servicio;

import com.omar.demo.dao.EvidenciaRepository;
import com.omar.demo.domain.Actividad;
import com.omar.demo.domain.Evidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EvidenciaServiceImp implements EvidenciaService {

    @Autowired
    EvidenciaRepository evidenciaRepository;

    @Override
    public Evidencia localizarPorId(Integer id) {
        return evidenciaRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Evidencia> localizarPorDescripcion(String descripcion) {
        return evidenciaRepository.findByDescripcion(descripcion);
    }

    @Override
    public List<Evidencia> localizarPorFecha(LocalDate fecha) {
        return evidenciaRepository.findByFecha(fecha);
    }

    @Override
    public List<Evidencia> localizarPorActividad(Actividad actividad) {
        return evidenciaRepository.findByActividad(actividad);
    }
}
