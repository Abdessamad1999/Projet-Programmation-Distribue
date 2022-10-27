package org.sid.serviceanneeuniversitaire.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnneeUniversitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnneeUniversitaire;
    @Column(unique = true)
    private String nomAnneeUniversitaire;
    private boolean courante;

    @OneToMany(mappedBy = "anneeUniversitaire")
    private List<Session> sessions;

    @OneToMany(mappedBy = "anneeUniversitaire")
    private List<FiliereAnneeUniversitaire> filieres;
}
