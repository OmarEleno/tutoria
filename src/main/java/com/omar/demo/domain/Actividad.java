package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ACTIVIDAD")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTID")
    private Integer id;

    @Column(name = "ACTNOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "SESIONID")
    private Sesion sesion;
}