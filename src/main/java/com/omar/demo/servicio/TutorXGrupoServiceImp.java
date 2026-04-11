package com.omar.demo.servicio;

import com.omar.demo.dao.TutorXGrupoRepository;
import com.omar.demo.domain.TutorXGrupo;
import com.omar.demo.domain.id.TutorXGrupoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorXGrupoServiceImp implements TutorXGrupoService{

    @Autowired
    TutorXGrupoRepository tutorXGrupoRepository;

    @Override
    public TutorXGrupo localizarPorId(TutorXGrupoId id) {
        return tutorXGrupoRepository.findById(id).orElseThrow(null) ;
    }
}
