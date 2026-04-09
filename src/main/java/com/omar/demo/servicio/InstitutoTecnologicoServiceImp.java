package com.omar.demo.servicio;

import com.omar.demo.dao.InstitutoTecnologicoRepository;
import com.omar.demo.domain.InstitutoTecnologico;
import com.omar.demo.domain.Tecnm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InstitutoTecnologicoServiceImp implements InstitutoTecnologicoService {

    @Autowired
    InstitutoTecnologicoRepository institutoTecnologicoRepository;

    @Override
    public InstitutoTecnologico lozalizarPorId(Integer id) {
        return institutoTecnologicoRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<InstitutoTecnologico> localizarPorCampus(String campus) {
        return institutoTecnologicoRepository.findByCampus(campus);
    }

    @Override
    public List<InstitutoTecnologico> LocalizarPorDireccion(String direccion) {
        return institutoTecnologicoRepository.findByDireccion(direccion);
    }

    @Override
    public List<InstitutoTecnologico> localizarPorTecnm(Tecnm tecnm) {
        return institutoTecnologicoRepository.findByTecnm(tecnm);
    }
}
