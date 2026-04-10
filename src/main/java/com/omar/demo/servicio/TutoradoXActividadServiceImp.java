package com.omar.demo.servicio;

import com.omar.demo.dao.TutoradoXActividadRepository;
import com.omar.demo.domain.TutoradoXActividad;
import com.omar.demo.domain.id.TutoradoXActividadId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutoradoXActividadServiceImp implements TutoradoXActividadService {

    @Autowired
    TutoradoXActividadRepository tutoradoXActividadRepository;

    @Override
    public TutoradoXActividad localizarPorId(TutoradoXActividadId id) {
        return tutoradoXActividadRepository.findById(id).orElseThrow(null);
    }
}
