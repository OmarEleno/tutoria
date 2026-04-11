package com.omar.demo.servicio;

import com.omar.demo.dao.TutoradoXAsistenciaRepository;
import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutorado;
import com.omar.demo.domain.TutoradoXAsistencia;
import com.omar.demo.domain.id.TutoradoXAsistenciaId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TutoradoXAsistenciaImp implements TutoradoXAsistenciaService {

    @Autowired
    TutoradoXAsistenciaRepository tutoradoXAsistenciaRepository;


    @Override
    public TutoradoXAsistencia localizarPorId(TutoradoXAsistenciaId id) {
        return tutoradoXAsistenciaRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<TutoradoXAsistencia> localizarPorAsistio(Boolean asistio) {
        return tutoradoXAsistenciaRepository.findByAsistio(asistio);
    }
}
