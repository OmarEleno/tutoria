package com.omar.demo.servicio;

import com.omar.demo.dao.TutorXGrupoRepository;
import com.omar.demo.domain.Tutor;
import com.omar.demo.domain.TutorXGrupo;
import com.omar.demo.domain.id.TutorXGrupoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorXGrupoServiceImp implements TutorXGrupoService{

    @Autowired
    TutorXGrupoRepository tutorXGrupoRepository;

    @Override
    public TutorXGrupo localizarPorId(TutorXGrupoId id) {
        return tutorXGrupoRepository.findById(id).orElseThrow(null) ;
    }

    @Override
    public void guardar(TutorXGrupo tutorXGrupo) {
         tutorXGrupoRepository.save(tutorXGrupo);
    }

    @Override
    public List<TutorXGrupo> localizarPorTutor(Tutor t) {
        return tutorXGrupoRepository.findByTutor(t);
    }
}
