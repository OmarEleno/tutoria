package com.omar.demo.servicio;

import com.omar.demo.domain.Tecnm;

import java.util.List;

public interface TecnmService {

    public Tecnm localizarPorId (Integer id);

    public List<Tecnm> localizarPorCorreo (String correo);

    public List<Tecnm> LocalizarPorSitioWeb (String sitioweb);

    public List<Tecnm> LocalizarPorCede (String CEDE);
}
