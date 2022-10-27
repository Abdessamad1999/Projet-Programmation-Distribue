package org.sid.serviceanneeuniversitaire.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.serviceanneeuniversitaire.enumerations.TypeSession;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSession;
    TypeSession typeSession;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    AnneeUniversitaire anneeUniversitaire;

    @OneToMany(mappedBy = "session")
    List<Semestre> semestres;
}
