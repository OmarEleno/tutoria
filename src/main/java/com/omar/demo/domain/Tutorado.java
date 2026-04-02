package com.omar.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TUTORADO")
public class Tutorado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TUTORADONC")
    private Integer id;

    @Column(name = "TUTORADONOMBRE")
    private String nombre;

    @Column(name = "TUTORADOAPEPAT")
    private String apellidoPaterno;

    @Column(name = "TUTORADOAPEMAT")
    private String apellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "CARID")
    private Carrera carrera;
}
