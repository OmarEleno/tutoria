package com.omar.demo.servicio;

import com.omar.demo.domain.InstitutoTecnologico;
import com.omar.demo.domain.Puesto;
import com.omar.demo.domain.Superior;

import java.util.List;

public interface SuperiorService {

    public Superior localizarPorId(Integer id);

    public List<Superior> localizarPorNombre(String nombre);

    public List<Superior> localizarPorApellidoPaterno(String apellidoPaterno);

    public List<Superior> localizarPorApellidoMaterno(String apellidoMaterno);

    public List<Superior> localizarPorPuesto(Puesto puesto);

    public List<Superior> localizarPorInstitutoTecnologico(InstitutoTecnologico institutoTecnologico);

}
