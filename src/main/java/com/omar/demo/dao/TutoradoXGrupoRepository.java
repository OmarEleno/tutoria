package com.omar.demo.dao;

import com.omar.demo.domain.TutoradoXGrupo;
import com.omar.demo.domain.id.TutoradoXGrupoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutoradoXGrupoRepository extends JpaRepository<TutoradoXGrupo, TutoradoXGrupoId> {

    public Optional<TutoradoXGrupo> findById(TutoradoXGrupoId id);

}
