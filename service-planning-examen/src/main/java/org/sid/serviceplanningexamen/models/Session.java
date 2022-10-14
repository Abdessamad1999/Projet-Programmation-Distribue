package org.sid.serviceplanningexamen.models;

import lombok.Data;
import org.sid.serviceplanningexamen.enumerations.TypeSession;

import java.util.List;

@Data
public class Session {

    Long idSession;
    TypeSession typeSession;
    AnneeUniversitaire anneeUniversitaire;
    List<Semestre> semestres;
}
