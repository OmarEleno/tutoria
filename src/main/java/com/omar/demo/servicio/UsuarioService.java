package com.omar.demo.servicio;

import com.omar.demo.domain.Usuario;
import org.springframework.stereotype.Service;


public interface UsuarioService {

    public Usuario localizarPorNombreDeUsuario(String nombreUsuario);
}
