package com.omar.demo.servicio;

import com.omar.demo.domain.InstitutoTecnologico;
import com.omar.demo.domain.Tecnm;

import java.util.List;

public interface InstitutoTecnologicoService {

    public InstitutoTecnologico lozalizarPorId(Integer id);

    public List<InstitutoTecnologico> localizarPorCampus(String campus);

    public List<InstitutoTecnologico> LocalizarPorDireccion(String direccion);

    public List<InstitutoTecnologico> localizarPorTecnm(Tecnm tecnm);

}
