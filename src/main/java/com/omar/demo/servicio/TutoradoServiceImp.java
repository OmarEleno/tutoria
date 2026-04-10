package com.omar.demo.servicio;

import com.omar.demo.dao.TutoradoRepository;
import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutorado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutoradoServiceImp implements TutoradoService {

    @Autowired
    TutoradoRepository tutoradoRepository;

    @Override
    public Tutorado localizarPorId(Integer id) {
        return tutoradoRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Tutorado> localizarPorNombre(String nombre) {
        return tutoradoRepository.findByNombre(nombre);
    }

    @Override
    public List<Tutorado> localizarPorApellidoPaterno(String apellidoPaterno) {
        return tutoradoRepository.findByApellidoPaterno(apellidoPaterno);
    }

    @Override
    public List<Tutorado> localizarPorApellidoMaterno(String apellidoMaterno) {
        return tutoradoRepository.findByApellidoMaterno(apellidoMaterno);
    }

    @Override
    public List<Tutorado> localizarPorCarrera(Carrera carrera) {
        return tutoradoRepository.findByCarrera(carrera);
    }
}
