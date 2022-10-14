package com.example.servicestructureenseignement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
public class Module {
    private Long id;
    private String nom;
    private Long moyen;
    private int coef;
    private Long idFiliere;
    private Collection<Element> elements;

}
