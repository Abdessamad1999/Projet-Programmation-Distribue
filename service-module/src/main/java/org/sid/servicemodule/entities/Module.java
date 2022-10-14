package org.sid.servicemodule.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="modules")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Module {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double moyen;
    private int coef;
    private Long idFiliere;
    @OneToMany(mappedBy = "module", fetch = FetchType.EAGER)
    private Collection<Element> elements;

}
