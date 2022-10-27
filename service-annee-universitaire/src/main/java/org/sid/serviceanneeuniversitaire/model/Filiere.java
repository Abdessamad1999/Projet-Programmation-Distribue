package org.sid.serviceanneeuniversitaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Filiere {
    private Long id;
    private String nomFilier;
    private int nombreAnnees;
    private int nombreSemestres;
    private int anneesDiplomante;
    private int anneesNonDiplomante;
    private Long idDepartement;
    private String responsableFiliere;

    //@Transient
    //private Collection<Module> modules;
}
