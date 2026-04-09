package com.omar.demo.servicio;

import com.omar.demo.domain.Departamento;
import com.omar.demo.domain.InstitutoTecnologico;

import java.util.List;

public interface DepartamentoService {

    public Departamento localizarPorId(Integer id);

    public List<Departamento> localizarPorNombre(String nombre);

    public List<Departamento> locaizarPorInstitutoTecnologico (InstitutoTecnologico institutoTecnologico);
}
