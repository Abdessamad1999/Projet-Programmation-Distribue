package org.sid.serviceanneeuniversitaire.repository;

import org.sid.serviceanneeuniversitaire.entities.FiliereAnneeUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StructureRepository extends JpaRepository<FiliereAnneeUniversitaire,Long> {
    FiliereAnneeUniversitaire findFiliereAnneeUniversitaireByIdFiliere(Long id);
}
