package com.omar.demo.dao;

import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRespository extends JpaRepository<Carrera, Integer> {

    public List<Carrera> findByClave(String clave );

    public List<Carrera> findByNombre(String Nombre );

   public List<Carrera> findByDepartamento(Departamento departamento);
}
