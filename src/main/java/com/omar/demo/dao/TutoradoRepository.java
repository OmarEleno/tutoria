package com.omar.demo.dao;

import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutorado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutoradoRepository extends JpaRepository<Tutorado,Integer> {

    public List<Tutorado> findByNombre(String nombre);

    public List<Tutorado> findByApellidoPaterno(String apellidoPaterno);

    public List<Tutorado> findByApellidoMaterno(String apellidoMaterno);

    public List<Tutorado> findByCarrera(Carrera carrera);

}
