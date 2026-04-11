package com.omar.demo.servicio;

import com.omar.demo.domain.Usuario;


public interface UsuarioService {

    public Usuario localizarPorNombreDeUsuario(String nombreUsuario);

    public Usuario guardarUsuario(Usuario usuario);
}
