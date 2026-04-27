package com.omar.demo.servicio;

import com.omar.demo.domain.Grupo;
import com.omar.demo.domain.Usuario;

import java.util.List;


public interface UsuarioService {

    public Usuario localizarPorNombreDeUsuario(String nombreUsuario);

    public Usuario guardarUsuario(Usuario usuario);

    public List<Usuario> localizarPorGrupo(Grupo grupo);
}
