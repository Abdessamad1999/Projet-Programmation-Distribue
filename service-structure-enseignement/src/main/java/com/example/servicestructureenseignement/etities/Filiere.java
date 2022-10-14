package com.example.servicestructureenseignement.etities;

import com.example.servicestructureenseignement.models.Module;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Filiere {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFilier;
    private int nombreAnnees;
    private int nombreSemestres;
    private int anneesDiplomante;
    private int anneesNonDiplomante;
    private Long idEtablissement;
    private String responsableFiliere;

    @Transient
    private Collection<Module> modules;
}
