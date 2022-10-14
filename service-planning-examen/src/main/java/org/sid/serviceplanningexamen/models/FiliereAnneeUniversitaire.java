package org.sid.serviceplanningexamen.models;

import lombok.Data;

@Data
public class FiliereAnneeUniversitaire {

    Long id;
    Long idFiliere;
    Filiere filiere;
    AnneeUniversitaire anneeUniversitaire;
}
