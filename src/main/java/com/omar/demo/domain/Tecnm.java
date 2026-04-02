package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "TECNM")
public class Tecnm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TECID")
    private Integer id;

    @Column(name = "CORREO")
    private  String correo;

    @Column(name = "SITIOWEB")
    private  String sitioweb;

    @Column(name = "CEDE")
    private  String CEDE;
}