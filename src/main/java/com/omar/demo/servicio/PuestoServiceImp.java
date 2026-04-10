package com.omar.demo.servicio;

import com.omar.demo.dao.PuestoRepository;
import com.omar.demo.domain.Puesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuestoServiceImp implements PuestoService {

    @Autowired
    PuestoRepository puestoRepository;

    @Override
    public Puesto localizarPorId(Integer id) {
        return puestoRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Puesto> localizarPorNombre(String nombre) {
        return puestoRepository.findByNombre(nombre);
    }
}
