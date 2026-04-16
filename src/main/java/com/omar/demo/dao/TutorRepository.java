package com.omar.demo.dao;


import com.omar.demo.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TutorRepository extends JpaRepository<Tutor , Integer> {

    public List<Tutor> findByIdEmpleado(Integer idEmpleado );

    public List<Tutor> findByCarrera(Carrera carrera);

    public Tutor findByUsuario(Usuario usuario);

    /*@Query(value = "select *\n" +
            "from TUTOR t\n" +
            "inner join CARRERA c on t.CARID=c.CARID\n" +
            "inner join DEPARTAMENTO d on d.DEPID = c.DEPID\n" +
            "where d.DEPID = :departamento",
            nativeQuery = true
    )*/
    @Query(value = "\n" +
            "select t " +
            "from TUTOR t \n" +
            "where t.CARID=12"
    )
    public List<Tutor> findByDepartamento(Integer departamento);

}
