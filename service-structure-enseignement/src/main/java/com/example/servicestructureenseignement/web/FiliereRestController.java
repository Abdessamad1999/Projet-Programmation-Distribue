package com.example.servicestructureenseignement.web;

import com.example.servicestructureenseignement.etities.Filiere;
//import com.example.servicestructureenseignement.fiegn.ModuleRestClient;
import com.example.servicestructureenseignement.models.Module;
import com.example.servicestructureenseignement.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
public class FiliereRestController {

    @Autowired
    private FiliereRepository filiereRepository;
//    private ModuleRestClient moduleRestClient;
//
//    public FiliereRestController(FiliereRepository filiereRepository,ModuleRestClient moduleRestClient){
//        this.filiereRepository = filiereRepository;
//        this.moduleRestClient = moduleRestClient;
//    }

    //Exeption not fond
    @GetMapping("/filieres/{id}")
    Filiere getFiliereById(@PathVariable Long id) {
        try {
            return filiereRepository.findById(id).get();
        }catch (NoSuchElementException e) {
            throw new NoSuchElementException("Filiere not fond with id : " + id);
        }

    }

    @GetMapping(path = "/filieres/nomFilier/{nom}")
    Filiere getFiliereByNomFiliere(@PathVariable String nom){
        Filiere filiere = filiereRepository.findFirstByNomFilier(nom);
        if(filiere!=null){
            return filiere;
        }else {
            throw new NoSuchElementException("Filiere "+nom+" not fond");
        }
    }

    @GetMapping("/{idEtab}/filieresAndModules")
    public Collection<Filiere> getFilieresAndModulesByIdEtab(@PathVariable Long idEtab){
        Collection<Filiere> filieres = filiereRepository.findByIdEtablissement(idEtab);
//        filieres.forEach(f->{
//            Collection<Module> modules = moduleRestClient.getModulesByFilieresId(f.getId());
//            f.setModules(modules);
//        });
        return filieres;
    }

    @GetMapping(path = "/filieres/idEtablissement/{id}")
    Collection<Filiere> getFilieresDepartement(@PathVariable Long id){
        return filiereRepository.findByIdEtablissement(id);
    }

    @PostMapping("/ajouterFiliere")
    public Filiere insertFiliere(@RequestBody Filiere filiere){
        return filiereRepository.save(filiere);
    }

    @PutMapping("/modifierFiliere")
    public Filiere editFiliere(@RequestBody Filiere filiere){
        return filiereRepository.save(filiere);
    }

    @DeleteMapping("/supprimerFilliere/{id}")
    public void deletFiliere(@PathVariable Long id){
//        moduleRestClient.deletModulesByFiliereId(id);
        filiereRepository.deleteById(id);
    }
}
