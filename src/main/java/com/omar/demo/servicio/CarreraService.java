package com.omar.demo.servicio;

import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Departamento;

import java.util.List;

public interface CarreraService {

    public Carrera localizarPorId(Integer id);

    public List<Carrera> localizarPorClave(String clave);

    public List<Carrera> localizarPorNombre(String Nombre);

    public List<Carrera> localizarPorDepartamento(Departamento departamento);
}
