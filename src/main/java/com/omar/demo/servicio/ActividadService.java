package com.omar.demo.servicio;

import com.omar.demo.domain.Actividad;
import com.omar.demo.domain.Sesion;

import java.util.List;

public interface ActividadService {

    public Actividad localizarPorId(Integer id);

    public List<Actividad> localizarPorNombre(String nombre);

    public List<Actividad> localizarPorSesion(Sesion sesion);

}
