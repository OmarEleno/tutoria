package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "DEPARTAMENTO")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPID")
    private Integer id;

    @Column(name = "DEPNOMBBRE")
    private  String nombre;

    @ManyToOne
    @JoinColumn(name = "ITCID")
    private  InstitutoTecnologico institutoTecnologico;
}