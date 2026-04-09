package com.omar.demo.servicio;

import com.omar.demo.domain.TutoradoXActividad;
import com.omar.demo.domain.id.TutoradoXActividadId;

public interface TutoradoXActividadService {

    public TutoradoXActividad localizarPorId(TutoradoXActividadId id);

}
