package com.omar.demo.servicio;

import com.omar.demo.domain.TutoradoXAsistencia;
import com.omar.demo.domain.id.TutoradoXAsistenciaId;

import java.util.List;

public interface TutoradoXAsistenciaService {

    public TutoradoXAsistencia localizarPorId(TutoradoXAsistenciaId id);

    public List<TutoradoXAsistencia> localizarPorAsistio(Boolean asistio);

}
