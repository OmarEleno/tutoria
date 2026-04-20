package com.omar.demo.servicio;

import com.omar.demo.domain.Grupo;

public interface GrupoService {

    public Grupo localizarPorId(Integer id);

    public void guardarGrupo(Grupo grupo);

}
