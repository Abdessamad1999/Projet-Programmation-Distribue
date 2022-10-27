package org.sid.serviceanneeuniversitaire.repository;

import org.sid.serviceanneeuniversitaire.entities.TypeSemestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeSemestreRepository extends JpaRepository<TypeSemestre,Long> {
}
