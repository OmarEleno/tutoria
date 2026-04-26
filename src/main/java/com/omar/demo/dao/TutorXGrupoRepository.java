package com.omar.demo.dao;

import com.omar.demo.domain.Tutor;
import com.omar.demo.domain.TutorXGrupo;
import com.omar.demo.domain.id.TutorXGrupoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TutorXGrupoRepository extends JpaRepository <TutorXGrupo , TutorXGrupoId> {


    public Optional<TutorXGrupo> findById (TutorXGrupoId id);

    public List<TutorXGrupo> findByTutor(Tutor tutor);
}
