package com.omar.demo.dao;

import com.omar.demo.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperiorRepository extends JpaRepository<Superior, Integer> {

    public List<Superior> findByNombre(String nombre);

    public List<Superior> findByApellidoPaterno(String apellidoPaterno);

    public List<Superior> findByApellidoMaterno(String apellidoMaterno);

    public List<Superior> findByPuesto(Puesto puesto);

    public List<Superior> findByInstitutoTecnologico(InstitutoTecnologico institutoTecnologico);

    public Superior findByUsuario(Usuario usuario);
}
