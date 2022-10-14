package org.sid.servicemodule.repositories;

import org.sid.servicemodule.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module,Long> {
    Collection<Module> findByIdFiliere(Long id);
}
