package com.omar.demo.dao;

import com.omar.demo.domain.Asistencia;
import com.omar.demo.domain.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia , Integer> {

    public List<Asistencia> findBySesion(Sesion sesion);

    public List<Asistencia> findByFecha(LocalDate fecha);


}
