package com.omar.demo.servicio;

import com.omar.demo.domain.Actividad;
import com.omar.demo.domain.Evidencia;

import java.time.LocalDate;
import java.util.List;

public interface EvidenciaService {

    public Evidencia localizarPorId(Integer id);

    public List<Evidencia> localizarPorDescripcion(String descripcion);

    public List<Evidencia> localizarPorFecha(LocalDate fecha);

    public List<Evidencia> localizarPorActividad(Actividad actividad);


}
