package com.omar.demo.servicio;

import com.omar.demo.domain.TutoradoXGrupo;
import com.omar.demo.domain.id.TutoradoXGrupoId;

public interface TutoradoXGrupoService {

    public TutoradoXGrupo localizarPorId(TutoradoXGrupoId id);

    public void guardar(TutoradoXGrupo tutoradoXGrupo);

}
