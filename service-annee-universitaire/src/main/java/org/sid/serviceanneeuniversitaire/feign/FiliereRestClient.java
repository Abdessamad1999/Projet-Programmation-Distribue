package org.sid.serviceanneeuniversitaire.feign;

import org.sid.serviceanneeuniversitaire.model.Filiere;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(name="SERVICE-STRUCTURE-ENSEIGNEMENT")
public interface FiliereRestClient {

    @GetMapping(path = "/filieres")
    Collection<Filiere> pageFilieres();

    @GetMapping(path = "/filieres/{id}")
    Filiere getFiliereById(@PathVariable Long id);

    @GetMapping(path = "/filieres/nomFilier/{nom}")
    Filiere getFiliereByNomFiliere(@PathVariable String nom);

    @GetMapping(path = "/filieres/idDepartement/{id}")
    Collection<Filiere> getFilieresDepartement(@PathVariable Long id);
}
