package org.sid.servicemodule.web;


import org.sid.servicemodule.entities.Module;
import org.sid.servicemodule.repositories.ElementRepository;
import org.sid.servicemodule.repositories.ModuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ModulesRestController {
    private ElementRepository elementRepository;
    private ModuleRepository moduleRepository;

    public ModulesRestController(ElementRepository elementRepository, ModuleRepository moduleRepository) {
        this.elementRepository = elementRepository;
        this.moduleRepository = moduleRepository;
    }

    @GetMapping(path = "/modules")
    public List<Module> getallModules() {
        return moduleRepository.findAll();
    }

    @GetMapping(path = "/modules/idFiliere/{id}")
    Collection<Module> getModulesByFilieresId(@PathVariable Long id){
        Collection<Module> modules = moduleRepository.findByIdFiliere(id);
        return modules;
    }

    @PostMapping(path = "/modules/delet/{id}")
    void deletModulesByFiliereId(@PathVariable Long id){
        Collection<Module> modules = moduleRepository.findByIdFiliere(id);
        modules.forEach(m->{
            m.getElements().forEach(e->{
                elementRepository.deleteById(e.getId());
            });
            moduleRepository.deleteById(m.getId());
        });
    }
}
