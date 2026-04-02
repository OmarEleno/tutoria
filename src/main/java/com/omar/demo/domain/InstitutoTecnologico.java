package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "INSITUTOTECNOLOGICO")
public class InstitutoTecnologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITCID")
    private Integer id;

    @Column(name = "CAMPUS")
    private  String campus;

    @Column (name = "DIRECCION")
    private  String direccion;

    @ManyToOne
    @JoinColumn(name = "TECID")
    private  Tecnm tecnm;
}