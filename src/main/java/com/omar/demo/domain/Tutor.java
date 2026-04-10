package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Table(name = "TUTOR")
    public class Tutor extends Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "TUTORID")
        private Integer id;

        @Column(name = "TUTORIDEMPLEADO")
        private  Integer idEmpleado;

        @ManyToOne
        @JoinColumn(name = "CARID")
        private  Carrera carrera;
}