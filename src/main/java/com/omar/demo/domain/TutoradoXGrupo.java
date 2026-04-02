package com.omar.demo.domain;

import com.omar.demo.domain.id.TutoradoXGrupoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(TutoradoXGrupoId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TUTORADOXGRUPO")
public class TutoradoXGrupo {

    @Id
    @ManyToOne
    @JoinColumn(name = "TUTORADONC")
    private Tutorado tutorado;

    @Id
    @ManyToOne
    @JoinColumn(name = "GRUID")
    private Grupo grupo;
}