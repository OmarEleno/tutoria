package com.omar.demo.dao;

import com.omar.demo.domain.TutoradoXActividad;
import com.omar.demo.domain.id.TutoradoXActividadId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutoradoXActividadRepository extends JpaRepository<TutoradoXActividad, TutoradoXActividadId> {

    public Optional<TutoradoXActividad> findById(TutoradoXActividadId id);

}
