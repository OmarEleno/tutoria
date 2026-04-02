package com.omar.demo.domain;

import com.omar.demo.domain.id.TutoradoXAsistenciaId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(TutoradoXAsistenciaId.class)
@Table(name = "TUTORADOXASISTENCIA")
public class TutoradoXAsistencia {

    @Id
    @ManyToOne
    @JoinColumn (name = "TUTORADONC")
    private  Tutorado tutorado;

    @Id
    @ManyToOne
    @JoinColumn(name = "ASIID")
    private  Asistencia asistencia;

    @Column(name = "ASISTIO")
    private  Boolean asistio;
}