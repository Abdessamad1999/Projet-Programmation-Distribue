package org.sid.serviceanneeuniversitaire.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSemestre;
    String nomSemestre;
    Long idFiliere;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "semestre_TypeSemestre")
    List<TypeSemestre> typeSemestres;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    Session session;
}