package org.sid.serviceanneeuniversitaire.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.serviceanneeuniversitaire.model.Filiere;

import javax.persistence.*;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class FiliereAnneeUniversitaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long idFiliere;
    @Transient
    Filiere filiere;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    AnneeUniversitaire anneeUniversitaire;
}
