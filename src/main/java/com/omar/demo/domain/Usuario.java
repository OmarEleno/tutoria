package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUID")
    private Integer id;

    @Column(name = "USUNOMUSUARIO")
    private String nombreUsuario;

    @Column(name = "USUPASSWORD")
    private String password;

    @Column(name = "ROL")
    private int rol;

    @Column(name = "USUNOMBRE")
    private String nombre;

    @Column(name = "USUAPEPAT")
    private String apePat;

    @Column(name = "USUAPEMAT")
    private String apeMat;
}
