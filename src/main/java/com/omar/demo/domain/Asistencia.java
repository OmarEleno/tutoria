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
    @Table(name = "ASISTENCIA")
    public class Asistencia{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ASIID")
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "SESIONID")
        private  Sesion sesion;

        @Column(name = "ASIFECHA")
        private LocalDate fecha;
}