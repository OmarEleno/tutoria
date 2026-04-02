package com.omar.demo.domain.id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TutorXGrupoId implements Serializable {

    private Integer tutor;
    private Integer grupo;

}
