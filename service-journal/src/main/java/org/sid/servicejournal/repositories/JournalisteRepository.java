package org.sid.servicejournal.repositories;

import org.sid.servicejournal.entities.Journaliste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JournalisteRepository extends JpaRepository<Journaliste,Long>{

}
