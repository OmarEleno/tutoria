package com.omar.demo.servicio;

import com.omar.demo.dao.UsuarioRepository;
import com.omar.demo.domain.Grupo;
import com.omar.demo.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario localizarPorNombreDeUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> localizarPorGrupo(Grupo grupo) {
        return usuarioRepository.findByGrupo(grupo.getId());
    }
}
