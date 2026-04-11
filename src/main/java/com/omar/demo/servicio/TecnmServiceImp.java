package com.omar.demo.servicio;

import com.omar.demo.dao.TecnmRepository;
import com.omar.demo.domain.Tecnm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnmServiceImp implements TecnmService{

    @Autowired
    TecnmRepository tecnmRepository;

    @Override
    public Tecnm localizarPorId(Integer id) {
        return tecnmRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Tecnm> localizarPorCorreo(String correo) {
        return tecnmRepository.findByCorreo(correo);
    }

    @Override
    public List<Tecnm> LocalizarPorSitioWeb(String sitioweb) {
        return tecnmRepository.findBySitioweb(sitioweb);
    }

    @Override
    public List<Tecnm> LocalizarPorCede(String CEDE) {
        return tecnmRepository.findByCEDE(CEDE);
    }
}
