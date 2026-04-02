package com.omar.demo.web;

import com.omar.demo.servicio.ReservacionesService;
import org.springframework.ui.Model;
import com.omar.demo.servicio.UsuarioService;
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


    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User usuarioSecurity){
        System.out.print("HAZ INICIADO SESION");
    }

}
