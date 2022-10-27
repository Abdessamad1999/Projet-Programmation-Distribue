package org.sid.serviceetablissement.web;

import org.sid.serviceetablissement.entities.Departement;
import org.sid.serviceetablissement.entities.Etablissement;
import org.sid.serviceetablissement.repositories.DepartementRepository;
import org.sid.serviceetablissement.repositories.EtablissementRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RestController
public class EtablissementRestController {

    private EtablissementRepository etablissementRepository;
    private DepartementRepository departementRepository;

    public EtablissementRestController(EtablissementRepository etablissementRepository, DepartementRepository departementRepository){
        this.etablissementRepository = etablissementRepository;
        this.departementRepository = departementRepository;
    }

    @GetMapping(path = "/etablissements")
    List<Etablissement> getEtablissement(){
        List<Etablissement> etablissements=etablissementRepository.findAll();
        return  etablissements;
    }

    @GetMapping(path = "/etablissement/{id}")
    Etablissement getEtablissementById(@PathVariable(name = "id")Long id){
        Etablissement etablissement=etablissementRepository.findById(id).get();
        return etablissement;
    }

    @PostMapping(path = "/etablissements")
    public Etablissement addEtablissement(@RequestBody Etablissement etablissement) throws IOException {
//        System.out.println(logo.getBytes());
//        System.out.println(logo);
        return etablissementRepository.save(etablissement);
    }
    
    @PostMapping(value = "/test",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Etablissement addEtablissementTest(@RequestPart("etablissement") Etablissement etablissement,
                                              @RequestPart("logo") MultipartFile logo) throws IOException{
        etablissement.setLogo(logo.getBytes());
        return etablissementRepository.save(etablissement);
    }

    @PutMapping(path="/etablissements/{id}")
    public Etablissement updateEtablissement(@PathVariable(name = "id") Long id, @RequestBody Etablissement etablissement){
        return etablissementRepository.save(etablissement);
    }

    @DeleteMapping(path = "/etablissements/{id}")
    public void deleteEtablissement(@PathVariable(name = "id") Long id){
        Collection<Departement> departements = departementRepository.findByEtablissementId(id);
        departements.forEach(d->{
            departementRepository.deleteById(d.getId());
        });
        etablissementRepository.deleteById(id);
    }

    @GetMapping("/{idEtablissement}/departements")
    public Collection<Departement> getDepartementByEtab(@PathVariable Long idEtablissement){
        return departementRepository.findByEtablissementId(idEtablissement);
    }

    @PostMapping(path = "/{idEtablissement}/departements")
    public Departement addDepartements(@PathVariable(name = "idEtablissement") Long idEtablissement, @RequestBody Departement departement){
        Etablissement e = etablissementRepository.findById(idEtablissement).get();
        departement.setEtablissement(e);
        return departementRepository.save(departement);
    }
    @PutMapping(path="/departements")
    public Departement updateDepartements(@RequestBody Departement departement){
        return departementRepository.save(departement);
    }

    @DeleteMapping(path = "/departements/{id}")
    public void deleteDepartements(@PathVariable(name = "id") Long id){
        departementRepository.deleteById(id);
    }

}
