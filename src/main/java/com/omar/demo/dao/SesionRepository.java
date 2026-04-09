package com.omar.demo.dao;

import com.omar.demo.domain.Grupo;
import com.omar.demo.domain.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SesionRepository extends JpaRepository <Sesion,Integer> {

    public List<Sesion> findByGrupo (Grupo grupo);

}
