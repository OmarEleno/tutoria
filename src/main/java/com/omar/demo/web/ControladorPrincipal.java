package com.omar.demo.web;

import com.omar.demo.dao.UsuarioRepository;
import com.omar.demo.domain.Superior;
import com.omar.demo.domain.Tutorado;
import com.omar.demo.domain.Usuario;
import com.omar.demo.servicio.SuperiorService;
import com.omar.demo.servicio.TutorService;
import com.omar.demo.servicio.TutoradoService;
import com.omar.demo.servicio.UsuarioService;
import org.springframework.ui.Model;
import org.springframework.security.core.userdetails.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Controller
@Slf4j
public class ControladorPrincipal {

    @Autowired
    TutoradoService tutoradoService;

    @Autowired
    SuperiorService superiorService;

    @Autowired
    TutorService tutorService;

    /*
    @Autowired
    UsuarioRepository usuarioRepository;
    */

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/login")
    public String login(){
        System.out.println("Se entro al login");
        return "login";
    }


    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User usuarioSecurity){
        System.out.println("INICIASTE SESION: "+usuarioSecurity.getUsername());
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usuarioSecurity.getUsername());

        int rol = usuario.getRol();

        switch (rol){
            case 0:
                return "director";
            case 1 :
                return "director";
            case 2:
                return  "director";
            case 3:
                return "coorInstTuto";
            case 4 :
                return "director";
            case 5:
                return "coorDepTutorias";
            case 6:
                return "tutor";
            case 7 :
                return "tutoradoVersion2";
        }

        return "/error";
    }

}
