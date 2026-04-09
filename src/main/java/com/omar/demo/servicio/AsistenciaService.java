package com.omar.demo.servicio;

import com.omar.demo.domain.Asistencia;
import com.omar.demo.domain.Sesion;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaService {

    public Asistencia localizarPorId(Integer id);

    public List<Asistencia> localizarPorSesion(Sesion sesion);

    public List<Asistencia> localizarPorFecha (LocalDate fecha);
}
