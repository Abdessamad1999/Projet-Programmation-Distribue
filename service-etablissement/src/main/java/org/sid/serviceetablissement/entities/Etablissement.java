package org.sid.serviceetablissement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomEtablissement;
    @Column(unique = true)
    private String abreviation;
    @Column(columnDefinition = "BLOB")
    private byte[] logo;
    @Column(unique = true)
    private String doyen;

    @OneToMany(mappedBy = "etablissement", fetch = FetchType.EAGER)
    private Collection<Departement> departements;
}
