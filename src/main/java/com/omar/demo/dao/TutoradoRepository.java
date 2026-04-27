package com.omar.demo.dao;

import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Grupo;
import com.omar.demo.domain.Tutorado;
import com.omar.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutoradoRepository extends JpaRepository<Tutorado,Integer> {
/*
    public List<Tutorado> findByNombre(String nombre);

    public List<Tutorado> findByApellidoPaterno(String apellidoPaterno);

    public List<Tutorado> findByApellidoMaterno(String apellidoMaterno);
*/
    public List<Tutorado> findByCarrera(Carrera carrera);

    public Tutorado findByUsuario(Usuario usuario);

    @Query(value = """
select tu.CARID, tu.TUTORADOCALIFICACION, tu.TUTORADONC, tu.USUID
from GRUPO g
inner join TUTORXGRUPO tg on tg.GRUID = g.GRUID
inner join TUTORADOXGRUPO tg2 on tg2.GRUID = g.GRUID
inner join tutor t on t.TUTORID = tg.TUTORID
inner join TUTORADO tu on tu.TUTORADONC = tg2.TUTORADONC
inner join Usuario usuTutor on usuTutor.USUID = t.USUID
inner join Usuario usuTutorado on usuTutorado.USUID = tu.USUID
where g.gruid = :idGrupo
""", nativeQuery = true)
    public List<Tutorado> findByGrupo(Integer idGrupo);
}
