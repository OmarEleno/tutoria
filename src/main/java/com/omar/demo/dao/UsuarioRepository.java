package com.omar.demo.dao;

import com.omar.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByNombreUsuario(String nombre);
}
