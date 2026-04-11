package com.omar.demo.servicio;

import com.omar.demo.dao.CarreraRespository;
import com.omar.demo.domain.Carrera;
import com.omar.demo.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServiceImp implements CarreraService{

    @Autowired
    CarreraRespository carreraRespository;

    @Override
    public Carrera localizarPorId(Integer id) {
        return carreraRespository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Carrera> localizarPorClave(String clave) {
        return carreraRespository.findByClave(clave);
    }

    @Override
    public List<Carrera> localizarPorNombre(String Nombre) {
        return carreraRespository.findByNombre(Nombre);
    }

    @Override
    public List<Carrera> localizarPorDepartamento(Departamento departamento) {
        return carreraRespository.findByDepartamento(departamento);
    }


}
