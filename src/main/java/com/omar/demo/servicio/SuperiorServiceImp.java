package com.omar.demo.servicio;

import com.omar.demo.dao.SuperiorRepository;
import com.omar.demo.domain.InstitutoTecnologico;
import com.omar.demo.domain.Puesto;
import com.omar.demo.domain.Superior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperiorServiceImp implements SuperiorService {

    @Autowired
    SuperiorRepository superiorRepository;

    @Override
    public Superior localizarPorId(Integer id) {
        return superiorRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Superior> localizarPorNombre(String nombre) {
        return superiorRepository.findByNombre(nombre);
    }

    @Override
    public List<Superior> localizarPorApellidoPaterno(String apellidoPaterno) {
        return superiorRepository.findByApellidoPaterno(apellidoPaterno);
    }

    @Override
    public List<Superior> localizarPorApellidoMaterno(String apellidoMaterno) {
        return superiorRepository.findByApellidoMaterno(apellidoMaterno);
    }

    @Override
    public List<Superior> localizarPorPuesto(Puesto puesto) {
        return superiorRepository.findByPuesto(puesto);
    }

    @Override
    public List<Superior> localizarPorInstitutoTecnologico(InstitutoTecnologico institutoTecnologico) {
        return superiorRepository.findByInstitutoTecnologico(institutoTecnologico);
    }
}
