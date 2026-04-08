package com.omar.demo.dao;

import com.omar.demo.domain.Departamento;
import com.omar.demo.domain.InstitutoTecnologico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository  extends JpaRepository<Departamento , Integer> {

    public List<Departamento> findByNombre (String Nombre);

    public List<Departamento> findByInstitutoTecnologico(InstitutoTecnologico institutoTecnologico);


}
