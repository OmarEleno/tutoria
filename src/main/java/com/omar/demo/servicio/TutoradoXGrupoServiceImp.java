package com.omar.demo.servicio;

import com.omar.demo.dao.TutoradoXGrupoRepository;
import com.omar.demo.domain.TutoradoXGrupo;
import com.omar.demo.domain.id.TutoradoXGrupoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutoradoXGrupoServiceImp implements TutoradoXGrupoService {

    @Autowired
    TutoradoXGrupoRepository tutoradoXGrupoRepository;

    @Override
    public TutoradoXGrupo localizarPorId(TutoradoXGrupoId id) {
        return tutoradoXGrupoRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void guardar(TutoradoXGrupo tutoradoXGrupo) {
        tutoradoXGrupoRepository.save(tutoradoXGrupo);
    }
}
