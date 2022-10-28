package org.sid.serviceplanningexamen.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.serviceplanningexamen.enumerations.Type;
import org.sid.serviceplanningexamen.models.AnneeUniversitaire;
import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class PlanningExamen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomFiliere;
    @Column(nullable = false)
    private String session;
    @Column(nullable = false)
    private String semestre;
    @Column(nullable = false)
    private Type typeExam;
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] avisExamen;
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] planningExamen;

    @Column(nullable = false)
    private Long idAnneeUniversitaire;
    @Transient
    private AnneeUniversitaire anneeUniversitaire;
}
