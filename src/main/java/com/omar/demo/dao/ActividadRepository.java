package com.omar.demo.dao;

import com.omar.demo.domain.Actividad;
import com.omar.demo.domain.Sesion;
import com.omar.demo.domain.TutoradoXAsistencia;
import com.omar.demo.domain.id.TutoradoXActividadId;
import com.omar.demo.domain.id.TutoradoXAsistenciaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    public List<Actividad> findByNombre(String nombre);

    public List<Actividad> findBySesion(Sesion sesion);

}
