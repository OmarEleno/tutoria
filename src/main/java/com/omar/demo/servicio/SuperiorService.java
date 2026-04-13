package com.omar.demo.servicio;

import com.omar.demo.domain.*;

import java.util.List;

public interface SuperiorService {

    public Superior localizarPorId(Integer id);

    public List<Superior> localizarPorNombre(String nombre);

    public List<Superior> localizarPorApellidoPaterno(String apellidoPaterno);

    public List<Superior> localizarPorApellidoMaterno(String apellidoMaterno);

    public List<Superior> localizarPorPuesto(Puesto puesto);

    public List<Superior> localizarPorInstitutoTecnologico(InstitutoTecnologico institutoTecnologico);

    public Superior localizarPorUsuario(Usuario usuario);

    public Superior guardarSuperior(Superior superior);
}
