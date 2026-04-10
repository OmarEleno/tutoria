package com.omar.demo.security;

import com.omar.demo.dao.SuperiorRepository;
import com.omar.demo.dao.TutorRepository;
import com.omar.demo.dao.TutoradoRepository;
import com.omar.demo.dao.UsuarioRepository;
import com.omar.demo.domain.Superior;
import com.omar.demo.domain.Tutorado;
import com.omar.demo.domain.Usuario;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        System.out.println("Estamos tratando de iniciar sesion");
        Usuario u = usuarioRepository.findByNombreUsuario(username);
        String rol = "";

        switch(u.getRol()){
            case 0:
                rol = "DIRECTOR";
                break;
            case 1 :
                rol = "SUBDIRECTOR ACADEMICO";
                break;
            case 2:
                rol = "JEFE DE DEPARTAMENTO DE DESARROLLO ACADEMICO";
                break;
            case 3:
                rol = "COORDINADOR INSTITUCIONAL DE TUTORIAS";
                break;
            case 4 :
                rol = "JEFE DE DEPARTAMENTO ACADEMICO";
                break;
            case 5:
                rol = "COORDINADOR DEPARTAMENTAL DE TUTORIAS";
                break;
            case 6:
                rol = "TUTOR";
                break;
            case 7 :
                rol = "TUTORADO";
                break;
        }

        return new User(u.getNombreUsuario(), u.getPassword(), Collections.singleton(new SimpleGrantedAuthority(rol)
            )
        );
    }
}

