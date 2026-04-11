package com.omar.demo.servicio;

import com.omar.demo.dao.GrupoRepository;
import com.omar.demo.domain.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoServiceImp implements GrupoService {

    @Autowired
    GrupoRepository grupoRepository;

    @Override
    public Grupo localizarPorId(Integer id) {
        return grupoRepository.findById(id).orElseThrow(null);
    }
}
