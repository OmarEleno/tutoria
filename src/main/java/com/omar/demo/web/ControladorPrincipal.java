package com.omar.demo.web;

import com.omar.demo.dao.UsuarioRepository;
import com.omar.demo.domain.*;
import com.omar.demo.servicio.*;
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

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    InstitutoTecnologicoService institutoTecnologicoService;

    @Autowired
    PuestoService puestoService;

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
        System.out.println("TU ROL ES: "+rol);
        switch (rol){
            case 0:
            case 1 :
            case 2:
            case 4:
                System.out.println("Eres consultor?");
                return "redirect:/consultor";
            case 3:
                return "redirect:/coorInstTuto";
                    case 5:
                return "redirect:/coorDepTutorias";
            case 6:
                return "redirect:/tutor";
            case 7 :
                return "redirect:/tutorado";
        }
        System.out.println("Nop");
        return "/error";
    }

    @GetMapping("/consultor")
    public String consultor(@AuthenticationPrincipal User userSecurity, Model model){
        System.out.println("BIENVENIDO AL SISTEMA DE CONSULTAS");
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(userSecurity.getUsername());
        Superior superior = superiorService.localizarPorUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("superior", superior);

        return "director";
    }

    @GetMapping("/tutorado")
    public String tutorado(@AuthenticationPrincipal User usersecurity, Model model){
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usersecurity.getUsername());
        Tutorado tutorado = tutoradoService.localizarPorUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("tutorado", tutorado);

        System.out.print("DATOS DEL USUARIO: "+usuario);
        System.out.print("\nDATOS DEL TUTORADO: "+tutorado);

        return "tutoradoVersion2";
    }

    @GetMapping("/coorInstTuto")
    public String coorInstTuto(@AuthenticationPrincipal User usersecurity, Model model){
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usersecurity.getUsername());
        Superior superior = superiorService.localizarPorUsuario(usuario);

        model.addAttribute("usuario", usuario);
        model.addAttribute("superior", superior);

        return "coorInstTuto";
    }

    @PostMapping("/agregarUsuario")
    public String agregarUsuario(@AuthenticationPrincipal User usersecurity){

        return "agregarUsuarios";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@AuthenticationPrincipal User usersecurity, @RequestParam String apePat, @RequestParam String apeMat, @RequestParam String nombre, @RequestParam String rol){
        Usuario usuario = new Usuario();
        usuario.setApeMat(apeMat);
        usuario.setApePat(apePat);
        usuario.setNombre(nombre);
        usuario.setRol((Integer.parseInt(rol)));
        usuario.setNombreUsuario(nombre.substring(0, 4));
        usuario.setPassword("12345");
        usuarioService.guardarUsuario(usuario);
        System.out.println("\nUsuario: "+usuario.getNombreUsuario()+ "\nContraseña: "+usuario.getPassword());

        InstitutoTecnologico institutoTecnologico = institutoTecnologicoService.lozalizarPorId(1);
        Puesto puesto = puestoService.localizarPorId(usuario.getRol());

        Superior superior = new Superior();
        superior.setUsuario(usuario);
        superior.setInstitutoTecnologico(institutoTecnologico);
        superior.setPuesto(puesto);
        superiorService.guardarSuperior(superior);

        return "redirect:/coorInstTuto";
    }

    @PostMapping("/salir")
    public String salir(){
        System.out.println("SAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return "redirect:/login?logout";
    }
}
