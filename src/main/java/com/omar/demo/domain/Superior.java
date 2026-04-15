package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "SUPERIOR")
public class Superior{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUPID")
    private Integer id;


    @Column(name = "SUPNOMBRE")
    private String nombre;

    @Column(name = "SUPAPEPATERNO")
    private String apellidoPaterno;

    @Column(name = "SUPAPEMATERNO")
    private String apellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "DEPID")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "PUEID")
    private Puesto puesto;

    @ManyToOne
    @JoinColumn(name = "ITCID")
    private InstitutoTecnologico institutoTecnologico;

    @ManyToOne
    @JoinColumn(name = "USUID")
    private Usuario usuario;
}