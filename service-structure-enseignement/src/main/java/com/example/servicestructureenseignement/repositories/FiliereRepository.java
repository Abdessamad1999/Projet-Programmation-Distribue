package com.example.servicestructureenseignement.repositories;

import com.example.servicestructureenseignement.etities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    Collection<Filiere> findByIdDepartement(Long id);
    Filiere findFirstByNomFilier(String nomFiliere);
}
