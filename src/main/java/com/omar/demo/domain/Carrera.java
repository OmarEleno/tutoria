package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "CARRERA")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARID")
    private Integer id;

    @Column(name = "CARCLAVE")
    private  String clave;

    @Column(name = "CARNOMBRE")
    private  String Nombre;

    @ManyToOne
    @JoinColumn(name = "DEPID")
    private  Departamento departamento;

}