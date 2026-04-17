package com.omar.demo.dao;


import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutor;
import com.omar.demo.domain.Tutorado;
import com.omar.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TutorRepository extends JpaRepository<Tutor , Integer> {

    public List<Tutor> findByIdEmpleado(Integer idEmpleado );

    public List<Tutor> findByCarrera(Carrera carrera);

    public Tutor findByUsuario(Usuario usuario);
/* SI SIRVE ESTA
    @Query(value = """
    select *
    from TUTOR t
    where t.CARID = 12
""",
        nativeQuery = true
)
/*
 */
@Query(value = """
  select t.TUTORID, t.TUTORIDEMPLEADO, t.CARID, t.USUID
  from TUTOR t
  inner join CARRERA c on c.CARID = t.CARID
  inner join DEPARTAMENTO d on d.DEPID = c.DEPID
  where d.DEPID= :departamento
""",
        nativeQuery = true
)
    public List<Tutor> findByDepartamento(Integer departamento);

}
