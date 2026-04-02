package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EVIDENCIA")
public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVIID")
    private Integer id;

    @Column(name = "EVIDESCRIPCION")
    private String descripcion;

    @Column(name = "EVIFECHA")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "ACTID")
    private Actividad actividad;
}