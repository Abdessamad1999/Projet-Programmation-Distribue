package com.example.servicestructureenseignement.fiegn;

import com.example.servicestructureenseignement.models.Module;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

//@FeignClient(name = "SERVICE-MODULE")

//public interface ModuleRestClient {
//    @GetMapping(path = "/modules/idFiliere/{id}")
//    Collection<Module> getModulesByFilieresId(@PathVariable Long id);
//
//    @PostMapping(path = "/modules/delete/{idF}")
//    void deletModulesByFiliereId(@PathVariable Long idF);
//}
