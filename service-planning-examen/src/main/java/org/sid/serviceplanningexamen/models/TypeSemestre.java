package org.sid.serviceplanningexamen.models;

import lombok.Data;
import org.sid.serviceplanningexamen.enumerations.Type;

import java.util.List;

@Data
public class TypeSemestre {

    Long id;
    Type typeSemestre;
    List<Semestre> semestres;
}
