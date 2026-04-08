package com.omar.demo.servicio;

import com.omar.demo.dao.TutoradoRepository;
import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutorado;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface TutoradoService {

    public Tutorado localizarPorId(Integer id);

    public List<Tutorado> localizarPorNombre(String nombre);

    public List<Tutorado> localizarPorApellidoPaterno(String apellidoPaterno);

    public List<Tutorado> localizarPorApellidoMaterno(String apellidoMaterno);

    public List<Tutorado> localizarPorCarrera(Carrera carrera);

}
