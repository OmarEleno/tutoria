package com.omar.demo.servicio;

import com.omar.demo.domain.TutorXGrupo;
import com.omar.demo.domain.TutoradoXGrupo;
import com.omar.demo.domain.id.TutorXGrupoId;

public interface TutorXGrupoService {

    public TutorXGrupo localizarPorId(TutorXGrupoId id);

    public void guardar(TutorXGrupo tutorXGrupo);
}
