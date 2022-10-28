package org.sid.serviceplanningexamen.models;

import lombok.Data;

import java.util.List;

@Data
public class AnneeUniversitaire {

    Long idAnneeUniversitaire;
    String nomAnneeUniversitaire;
    List<Session> sessions;
    List<FiliereAnneeUniversitaire> filieres;
}
