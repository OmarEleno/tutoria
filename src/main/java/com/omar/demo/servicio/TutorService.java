package com.omar.demo.servicio;

import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutor;

import java.util.List;

public interface TutorService {

    public Tutor lozalizarPorId(Integer id);

    public List<Tutor> localizarPorIdEmpleado(Integer idEmpleado);

    public List<Tutor> lozalizarPorCarrera(Carrera carrera);
}
