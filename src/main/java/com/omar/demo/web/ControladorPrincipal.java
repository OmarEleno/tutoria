package com.omar.demo.web;

import com.omar.demo.dao.UsuarioRepository;
import com.omar.demo.domain.*;
import com.omar.demo.domain.id.TutorXGrupoId;
import com.omar.demo.servicio.*;
import org.springframework.ui.Model;
import org.springframework.security.core.userdetails.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    CarreraService carreraService;

    @Autowired
    DepartamentoService departamentoService;

    @Autowired
    GrupoService grupoService;

    @Autowired
    TutorXGrupoService tutorXGrupoService;

    @Autowired
    TutoradoXGrupoService tutoradoXGrupoService;

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
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
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
    public String consultor(@AuthenticationPrincipal User userSecurity, Model model) {
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

        String carreraMayus = tutorado.getCarrera().getNombre().toUpperCase();
        model.addAttribute( "carreraMayus" ,carreraMayus);
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

    @GetMapping("/agregarUsuario")
    public String mostrarFormulario(@AuthenticationPrincipal User usersecurity){
        System.out.println("Entrando al GET de agregarUsuario");
        return "agregarUsuarios";
    }

    @PostMapping  ("/agregarUsuario")
    public String agregarUsuario(@AuthenticationPrincipal User usersecurity){
        System.out.println("Bienvenidos a mi metodo");
        return "agregarUsuarios";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@AuthenticationPrincipal User usersecurity, @RequestParam String apePat, @RequestParam String apeMat, @RequestParam String nombre, @RequestParam String rol, RedirectAttributes redirectAttributes){
       System.out.println("VUELVE A ENTRAR AL METODO");
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

        int departamento = -1;
        int rolInt = usuario.getRol();
        switch (rolInt){
            case 10:
                departamento = 2;
                break;
            case 11:
                departamento = 3;
                break;
            case 12:
                departamento = 4;
                break;
            case 13:
                departamento = 1;
                break;
            case 14:
                departamento = 5;
                break;
            case 15:
                departamento = 6;
                break;
        }

        if (departamento != -1) {
            superior.setDepartamento(departamentoService.localizarPorId(departamento));
        }
        superiorService.guardarSuperior(superior);
        System.out.println("Redirigete");
        redirectAttributes.addFlashAttribute("mensajeExito", "Usuario agregado con exito");
        System.out.println("Si se redirigio el atributo");

        return "redirect:/agregarUsuario";
    }

    @PostMapping("/salir")
    public String salir(){
        System.out.println("SAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return "redirect:/login?logout";
    }

    @PostMapping("/regresar")
    public String regresar(){
        return "redirect:/";
    }

    @GetMapping("/coorDepTutorias")
    public String coorDepTut(@AuthenticationPrincipal User usersecurity, Model model) {
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usersecurity.getUsername());
        Superior superior = superiorService.localizarPorUsuario(usuario);

        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("apePat", usuario.getApePat());
        model.addAttribute("apeMat", usuario.getApeMat());

        model.addAttribute("rol", superior.getPuesto().getNombre());

        System.out.println("Dep: "+superior.getDepartamento());

        //String deo
        model.addAttribute( "departamento", superior.getDepartamento());
        model.addAttribute(superior);
        model.addAttribute(usuario);
        return "coorDepTutorias";
    }

    @GetMapping("/altaTutor")
    public String altaTutor(@AuthenticationPrincipal User usersecurity, Model model){
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usersecurity.getUsername());
        Superior superior = superiorService.localizarPorUsuario(usuario);
        Departamento departamento = superior.getDepartamento();

        model.addAttribute("departamento", departamento);
        model.addAttribute("carrerasDisponibles", carreraService.localizarPorDepartamento(departamento));
        return "agregarTutores";
    }

    @PostMapping("/guardarTutor")
    public String guardarTutor( RedirectAttributes redirectAttributes,@RequestParam String apePat, @RequestParam String apeMat, @RequestParam String nombre, @RequestParam String carrera, @RequestParam String clave){
        System.out.println("INTENTANDO GUARDAR TUTOR ::::");
        Usuario usuario = new Usuario();
        usuario.setApeMat(apeMat);
        usuario.setApePat(apePat);
        usuario.setNombre(nombre);
        usuario.setRol(6);
        usuario.setNombreUsuario(nombre.substring(0, 4));
        usuario.setPassword("12345");
        usuarioService.guardarUsuario(usuario);
        System.out.println("\nUsuario: "+usuario.getNombreUsuario()+ "\nContraseña: "+usuario.getPassword());

        Carrera car = carreraService.localizarPorId(Integer.parseInt(carrera));

        Tutor tutor = new Tutor();
       tutor.setCarrera(car);
        tutor.setUsuario(usuario);
        tutor.setIdEmpleado(Integer.parseInt(clave));

        tutorService.guardarTutor(tutor);

        //INTENTAMOS CREAR UN GRUPO
        Grupo grupo = new Grupo();
        //grupo.setId(tutor.getId());
        grupoService.guardarGrupo(grupo);
        System.out.println("GRUPO: "+grupo);
        System.out.println("ID TUTOR: "+tutor.getId()+" -ID GRUPO: "+grupo.getId());
        TutorXGrupo tutorXGrupo = new TutorXGrupo();
        tutorXGrupo.setTutor(tutor);
        tutorXGrupo.setGrupo(grupo);
        System.out.println("ID TUTORXGRUPO TUTOR: "+tutorXGrupo.getTutor().getId()+"--"+tutorXGrupo.getGrupo().getId());

        tutorXGrupoService.guardar(tutorXGrupo);
        System.out.println("SE GUARDO EL GRUPO Y TUTORXGRUPO");
        redirectAttributes.addFlashAttribute("mensajeExito", "Tutor dado de alta con exito");
        return "redirect:/altaTutor";
    }

    @GetMapping("/tutor")
    public String tutor(@AuthenticationPrincipal User usersecurity, Model model){
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usersecurity.getUsername());
        Tutor tutor = tutorService.localizarPorUsuario(usuario);


        Departamento departamento = tutor.getCarrera().getDepartamento();

        model.addAttribute("departamento", departamento);

        String carreraMayus = tutor.getCarrera().getNombre().toUpperCase();
        model.addAttribute( "carreraMayus" ,carreraMayus);

        model.addAttribute("usuario", usuario);
        model.addAttribute("tutor", tutor);
        model.addAttribute("carrera", tutor.getCarrera());
        return "tutor";
    }


    @GetMapping("/altaTutorado")
    public String altaTutorado(@AuthenticationPrincipal User usersecurity, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.localizarPorNombreDeUsuario(usersecurity.getUsername());
        Superior superior = superiorService.localizarPorUsuario(usuario);
        Departamento departamento = departamentoService.localizarPorId(superior.getDepartamento().getId());
        List<Tutor> tutores = tutorService.localizarPorDepartamento(departamento.getId());
        List<Carrera> carreras = carreraService.localizarPorDepartamento(departamento);

       /* Tutor tutor = tutorService.lozalizarPorId(1);

        redirectAttributes.addFlashAttribute("tutor", tutor);
        System.out.println(tutor);
*/
        model.addAttribute("departamento", superior.getDepartamento());
        model.addAttribute("usuario", usuario);
        model.addAttribute("tutores", tutores);
        System.out.println("Departamento: "+departamento.getNombre());
        System.out.println("aqui vienen los encontrados: ");
        /*for(int i=1; i<tutores.size(); i++) {
            System.out.println(tutores.get(i));

        }*/

        return "agregarTutorados";
    }

    @PostMapping("/buscarTutor")
    public String buscarTutor(@RequestParam String id, RedirectAttributes redirectAttributes){
        System.out.println("SE ESTA BUSCANDO UN TUTOR");
        System.out.println("ID: "+id);
        if(id.equals("a")){
            return "redirect:/altaTutorado";
        }
        Tutor tutor = tutorService.lozalizarPorId(Integer.parseInt(id));
        Usuario usuario = tutor.getUsuario();
        System.out.println("TOSTRING:");
        System.out.println(tutor);



        //INTENTANDO PONER EL GRUPO
        TutorXGrupo tutorXGrupo = tutorXGrupoService.localizarPorTutor(tutor).get(0);
        Grupo grupo = grupoService.localizarPorId(tutorXGrupo.getGrupo().getId());

        //Valores tabla
        redirectAttributes.addFlashAttribute("tutor", tutor);
        redirectAttributes.addFlashAttribute("usuarioTutor", usuario);

        List<Tutorado> tutoradosDelTutor = tutoradoService.localizarPorGrupo(grupo);
        System.out.println("Tutorados encontrados: "+tutoradosDelTutor.size());

        List<Usuario> usuariosDelTutor = usuarioService.localizarPorGrupo(grupo);
        System.out.println("usuario encontrados: "+usuariosDelTutor.size());

        redirectAttributes.addFlashAttribute("tutorados", tutoradosDelTutor);
        redirectAttributes.addFlashAttribute("usuariosT", usuariosDelTutor);
        redirectAttributes.addFlashAttribute("totalTutorados", tutoradosDelTutor.size());
        return "redirect:/altaTutorado";
    }


    @PostMapping("/guardarTutorado")
    public String guardarTutorado(@RequestParam String numControl, @RequestParam String nombreTutor, @RequestParam String apePat, @RequestParam String apeMat, @RequestParam String nombre, RedirectAttributes redirectAttributes) {
        System.out.println("SE INTENTA GUARDAR UN TUTORADO");
        System.out.println("NOMBRE RECIBIDO: " + nombreTutor);

        Usuario usuario = new Usuario();
        Tutorado tutorado = new Tutorado();

        usuario.setApePat(apePat);
        usuario.setApeMat(apeMat);
        usuario.setNombre(nombre);
        usuario.setRol(7);
        usuario.setNombreUsuario(nombre.substring(0, 4));
        usuario.setPassword("12345");
        usuarioService.guardarUsuario(usuario);
        tutorado.setUsuario(usuario);
        System.out.println("USUARIO CREADO::::::" + usuario);


        Usuario usuarioTutor = usuarioService.localizarPorNombreDeUsuario(nombreTutor);
        System.out.println("USUARIO DEL TUTOR:::::::::::" + usuarioTutor);

        Tutor tutor = tutorService.localizarPorUsuario(usuarioTutor);

        System.out.println("TUTOR: " + tutor);
        tutorado.setCarrera(tutor.getCarrera());
        tutorado.setId(Integer.parseInt(numControl));

        System.out.println("TUTORADO CREADO::::::" + tutorado);
        tutoradoService.guardarTutorado(tutorado);
        System.out.println("TUTORADO GUARDADO CON EXITO");
        System.out.println(tutorado);

        //Metiedolo a un grupo
        TutorXGrupo tutorXGrupo = tutorXGrupoService.localizarPorTutor(tutor).get(0);
        Grupo grupo = grupoService.localizarPorId(tutorXGrupo.getGrupo().getId());


        TutoradoXGrupo tutoradoXGrupo = new TutoradoXGrupo();
        tutoradoXGrupo.setTutorado(tutorado);
        tutoradoXGrupo.setGrupo(grupo);

        tutoradoXGrupoService.guardar(tutoradoXGrupo);

        //Valores tabla
        redirectAttributes.addFlashAttribute("tutor", tutor);
        redirectAttributes.addFlashAttribute("usuarioTutor", usuarioTutor);

        List<Tutorado> tutoradosDelTutor = tutoradoService.localizarPorGrupo(grupo);
        System.out.println("Tutorados encontrados: "+tutoradosDelTutor.size());

        List<Usuario> usuariosDelTutor = usuarioService.localizarPorGrupo(grupo);
        System.out.println("usuario encontrados: "+usuariosDelTutor.size());


        redirectAttributes.addFlashAttribute("tutorados", tutoradosDelTutor);
        redirectAttributes.addFlashAttribute("usuariosT", usuariosDelTutor);
        redirectAttributes.addFlashAttribute("totalTutorados", tutoradosDelTutor.size());

        System.out.println("SE GUARDO EN UN GRUPO: "+tutoradoXGrupo.getGrupo().getId());
        redirectAttributes.addFlashAttribute("mensajeExito", "Tutorado registrado con exito");
        return "redirect:/altaTutorado";
    }

}

