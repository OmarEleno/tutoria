package com.omar.demo.dao;


import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TutorRepository extends JpaRepository<Tutor , Integer> {

    public List<Tutor> findByIdEmpleado(Integer idEmpleado );

    public List<Tutor> findByCarrera(Carrera carrera);


}
