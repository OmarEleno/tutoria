package com.omar.demo.dao;

import com.omar.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByNombreUsuario(String nombre);

    @Query(value = """
select usuTutorado.USUID, usuTutorado.ROL, usuTutorado.USUAPEMAT, usuTutorado.USUAPEPAT, usuTutorado.USUNOMBRE, usuTutorado.USUNOMUSUARIO, usuTutorado.USUPASSWORD
from GRUPO g
inner join TUTORXGRUPO tg on tg.GRUID = g.GRUID
inner join TUTORADOXGRUPO tg2 on tg2.GRUID = g.GRUID
inner join tutor t on t.TUTORID = tg.TUTORID
inner join TUTORADO tu on tu.TUTORADONC = tg2.TUTORADONC
inner join Usuario usuTutor on usuTutor.USUID = t.USUID
inner join Usuario usuTutorado on usuTutorado.USUID = tu.USUID
where g.gruid = :idGrupo
""", nativeQuery = true)
    public List<Usuario> findByGrupo(Integer idGrupo);

}
