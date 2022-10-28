package org.sid.serviceplanningexamen.models;

import lombok.Data;

@Data
public class Filiere {
    private Long id;
    private String nomFilier;
    private int nombreAnnees;
    private int nombreSemestres;
    private int anneesDiplomante;
    private int anneesNonDiplomante;
    private Long idEtablissement;
    private String responsableFiliere;
}
