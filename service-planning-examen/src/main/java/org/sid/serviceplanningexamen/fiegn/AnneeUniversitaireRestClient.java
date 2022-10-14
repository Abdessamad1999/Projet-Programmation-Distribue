package org.sid.serviceplanningexamen.fiegn;

import org.sid.serviceplanningexamen.models.AnneeUniversitaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-ANNEE-UNIVERSITAIRE")
public interface AnneeUniversitaireRestClient {

    @GetMapping(path = "/anneeUniversitaire/{id}")
    AnneeUniversitaire getAnnee(@PathVariable Long id);
}
