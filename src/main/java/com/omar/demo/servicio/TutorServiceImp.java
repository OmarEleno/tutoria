package com.omar.demo.servicio;

import com.omar.demo.dao.TutorRepository;
import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Superior;
import com.omar.demo.domain.Tutor;
import com.omar.demo.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImp implements TutorService {

    @Autowired
    TutorRepository tutorRepository;

    @Override
    public Tutor lozalizarPorId(Integer id) {
        return tutorRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Tutor> localizarPorIdEmpleado(Integer idEmpleado) {
        return tutorRepository.findByIdEmpleado(idEmpleado);
    }

    @Override
    public List<Tutor> lozalizarPorCarrera(Carrera carrera) {
        return tutorRepository.findByCarrera(carrera);
    }

    @Override
    public Tutor localizarPorUsuario(Usuario usuario) {
        return tutorRepository.findByUsuario(usuario);
    }

    @Override
    public void guardarTutor(Tutor tutor) {
        tutorRepository.save(tutor);
    }

    @Override
    public List<Tutor> localizarPorDepartamento(Integer departamento) {
        return tutorRepository.findByDepartamento(departamento);
    }
}
