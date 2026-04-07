package com.omar.demo.dao;

import com.omar.demo.domain.Actividad;
import com.omar.demo.domain.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EvidenciaRepository extends JpaRepository<Evidencia, Integer> {

    public List<Evidencia> findByDescripcion(String descripcion);

    public List<Evidencia> findByFecha(LocalDate fecha);

    public List<Evidencia> findByActividad(Actividad actividad);

}
