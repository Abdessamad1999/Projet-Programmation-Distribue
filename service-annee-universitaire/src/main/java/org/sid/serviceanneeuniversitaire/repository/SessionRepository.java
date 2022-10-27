package org.sid.serviceanneeuniversitaire.repository;

import org.sid.serviceanneeuniversitaire.entities.Session;
import org.sid.serviceanneeuniversitaire.enumerations.TypeSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
@RepositoryRestResource
public interface SessionRepository extends JpaRepository<Session, Long> {
}
