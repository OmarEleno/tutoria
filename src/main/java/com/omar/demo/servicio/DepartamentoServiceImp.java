package com.omar.demo.servicio;

import com.omar.demo.dao.DepartamentoRepository;
import com.omar.demo.domain.Departamento;
import com.omar.demo.domain.InstitutoTecnologico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImp implements  DepartamentoService{

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public Departamento localizarPorId(Integer id) {
        return departamentoRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Departamento> localizarPorNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
    }

    @Override
    public List<Departamento> locaizarPorInstitutoTecnologico(InstitutoTecnologico institutoTecnologico) {
        return departamentoRepository.findByInstitutoTecnologico(institutoTecnologico);
    }
}
