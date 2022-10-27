package org.sid.servicemodule.repositories;

import org.sid.servicemodule.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.Optional;

@RepositoryRestResource
public interface ElementRepository extends JpaRepository<Element,Long> {
    Collection<Element> findByModuleId(Long id);

}

