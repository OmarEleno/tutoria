package com.omar.demo.servicio;

import com.omar.demo.domain.Puesto;

import java.util.List;

public interface PuestoService {

    public Puesto localizarPorId(Integer id);

    public List<Puesto> localizarPorNombre(String nombre);

}
