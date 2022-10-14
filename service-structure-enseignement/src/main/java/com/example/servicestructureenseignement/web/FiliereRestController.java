package com.example.servicestructureenseignement.web;

import com.example.servicestructureenseignement.etities.Filiere;
import com.example.servicestructureenseignement.fiegn.ModuleRestClient;
import com.example.servicestructureenseignement.models.Module;
import com.example.servicestructureenseignement.repositories.FiliereRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("*")
public class FiliereRestController {

    private FiliereRepository filiereRepository;
    private ModuleRestClient moduleRestClient;

    public FiliereRestController(FiliereRepository filiereRepository,ModuleRestClient moduleRestClient){
        this.filiereRepository = filiereRepository;
        this.moduleRestClient = moduleRestClient;
    }

    @GetMapping("/{idEtab}/filieresAndModules")
    public Collection<Filiere> getFilieresAndModulesByIdEtab(@PathVariable Long idEtab){
        Collection<Filiere> filieres = filiereRepository.findByIdEtablissement(idEtab);
        filieres.forEach(f->{
            Collection<Module> modules = moduleRestClient.getModulesByFilieresId(f.getId());
            f.setModules(modules);
        });
        return filieres;
    }

    @GetMapping(path = "/filieres/idEtablisement/{id}")
    Collection<Filiere> getFilieresEtablissement(@PathVariable Long id){
        Collection<Filiere> filieres = filiereRepository.findByIdEtablissement(id);
        return filieres;
    }

    @PostMapping("/ajouterFiliere")
    public Filiere insertFiliere(@RequestBody Filiere filiere){
        return filiereRepository.save(filiere);
    }

    @PutMapping("/modifierFiliere")
    public Filiere editFiliere(@RequestBody Filiere filiere){
        return filiereRepository.save(filiere);
    }

    //mais ajour => module *----1 apartian *----1 filiere
    @DeleteMapping("/supprimerFilliere/{id}")
    public void deletFiliere(@PathVariable Long id){
        moduleRestClient.deletModulesByFiliereId(id);
        filiereRepository.deleteById(id);
    }
}
