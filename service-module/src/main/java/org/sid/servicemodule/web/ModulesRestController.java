package org.sid.servicemodule.web;


import org.sid.servicemodule.entities.Module;
import org.sid.servicemodule.repositories.ElementRepository;
import org.sid.servicemodule.repositories.ModuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
public class ModulesRestController {
    private ElementRepository elementRepository;
    private ModuleRepository moduleRepository;

    public ModulesRestController(ElementRepository elementRepository, ModuleRepository moduleRepository) {
        this.elementRepository = elementRepository;
        this.moduleRepository = moduleRepository;
    }

    @GetMapping(path = "/modules/idFiliere/{id}")
    Collection<Module> getModulesByFilieresId(@PathVariable Long id){
        return moduleRepository.findByIdFiliere(id);
    }

    @DeleteMapping(path = "/modules/delete/{id}")
    void deletModulesByFiliereId(@PathVariable Long id){
        Collection<Module> modules = moduleRepository.findByIdFiliere(id);
        modules.forEach(m->{
            m.getElements().forEach(e->{
                elementRepository.deleteById(e.getId());
            });
            moduleRepository.deleteById(m.getId());
        });
    }

    /*@DeleteMapping(path = "/module/{id}")
    void deletModule(@PathVariable Long id){
        Module module = moduleRepository.findById(id).get();
        module.getElements().forEach(element-> elementRepository.deleteById(element.getId()));
    }*/
}
