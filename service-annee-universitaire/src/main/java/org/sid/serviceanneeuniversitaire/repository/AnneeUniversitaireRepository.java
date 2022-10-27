package org.sid.serviceanneeuniversitaire.repository;

import org.sid.serviceanneeuniversitaire.entities.AnneeUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface AnneeUniversitaireRepository extends JpaRepository<AnneeUniversitaire, Long> {
    AnneeUniversitaire findByNomAnneeUniversitaire(String anneeUniversitaire);
    AnneeUniversitaire findFirstByCouranteIsTrue();
}
