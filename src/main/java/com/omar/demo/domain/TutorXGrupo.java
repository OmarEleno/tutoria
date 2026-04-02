package com.omar.demo.domain;

import com.omar.demo.domain.id.TutorXGrupoId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(TutorXGrupoId.class)
@Table(name = "TUTORXGRUPO")
public class TutorXGrupo {

    @Id
    @ManyToOne
    @JoinColumn(name = "TUTORID")
    private  Tutor tutor;

    @Id
    @ManyToOne
    @JoinColumn (name = "GRUPID")
    private  Grupo grupo;
}