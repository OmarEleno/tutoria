package com.omar.demo.dao;

import com.omar.demo.domain.Tecnm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TecnmRepository extends JpaRepository<Tecnm, Integer> {

    public List<Tecnm> findByCorreo (String correo);

    public List<Tecnm> findBySitioweb(String sitioweb);

    public List<Tecnm> findByCEDE (String CEDE);

}
