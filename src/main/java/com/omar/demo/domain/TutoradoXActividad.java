package com.omar.demo.domain;

import com.omar.demo.domain.id.TutoradoXActividadId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(TutoradoXActividadId.class)
@Table(name = "TUTORADOXACTIVIDAD")
public class TutoradoXActividad {

    @Id
    @ManyToOne
    @JoinColumn(name = "TUTORADONC")
    private Tutorado tutorado;

    @Id
    @ManyToOne
    @JoinColumn(name = "ACTID")
    private Actividad actividad;
}