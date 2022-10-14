package com.example.servicestructureenseignement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Element {
    private Long id;
    private String nom;
    private int coef;
    @JsonIgnore
    private Module module;

}
