package com.omar.demo.dao;

import com.omar.demo.domain.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuestoRepository extends JpaRepository<Puesto, Integer> {

    public List<Puesto> findByNombre(String nombre);

}
