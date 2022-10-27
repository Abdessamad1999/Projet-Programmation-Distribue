package org.sid.serviceetablissement.repositories;

import org.sid.serviceetablissement.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement,Long> {
    Collection<Departement> findByEtablissementId(Long id);
}
