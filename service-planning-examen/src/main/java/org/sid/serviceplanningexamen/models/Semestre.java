package org.sid.serviceplanningexamen.models;

import lombok.Data;

import java.util.List;

@Data
public class Semestre {

    Long idSemestre;
    String nomSemestre;
    Long idFiliere;
    List<TypeSemestre> typeSemestres;
    Session session;
}