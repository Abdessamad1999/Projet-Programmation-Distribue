package org.sid.serviceanneeuniversitaire.repository;

import org.sid.serviceanneeuniversitaire.entities.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@RepositoryRestResource
public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    Collection<Semestre> findSemestreByNomSemestre(String nomSemestre);
    Collection<Semestre> findSemestreByIdFiliere(Long id);
    Collection<Semestre> findSemestreBySession(Long id);

}
