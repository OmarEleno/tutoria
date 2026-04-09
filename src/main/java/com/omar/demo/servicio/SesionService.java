package com.omar.demo.servicio;

import com.omar.demo.domain.Grupo;
import com.omar.demo.domain.Sesion;

import java.util.List;

public interface SesionService {

    public Sesion localizarPorId(Integer id);

    public List<Sesion> localizarPorGrupo(Grupo grupo);

}
