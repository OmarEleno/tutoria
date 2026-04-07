package com.omar.demo.dao;

import com.omar.demo.domain.InstitutoTecnologico;
import com.omar.demo.domain.Tecnm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitutoTecnologicoRepository extends JpaRepository<InstitutoTecnologico, Integer> {

    public List<InstitutoTecnologico> findByCampus(String campus);

    public List<InstitutoTecnologico> findByDireccion(String direccion);

    public List<InstitutoTecnologico> findByTecnm(Tecnm tecnm);
}
