package org.sid.serviceanneeuniversitaire.controller;

import org.sid.serviceanneeuniversitaire.entities.AnneeUniversitaire;
import org.sid.serviceanneeuniversitaire.entities.Semestre;
import org.sid.serviceanneeuniversitaire.entities.Session;
import org.sid.serviceanneeuniversitaire.enumerations.TypeSession;
import org.sid.serviceanneeuniversitaire.feign.FiliereRestClient;
import org.sid.serviceanneeuniversitaire.model.Filiere;
import org.sid.serviceanneeuniversitaire.repository.AnneeUniversitaireRepository;
import org.sid.serviceanneeuniversitaire.repository.SemestreRepository;
import org.sid.serviceanneeuniversitaire.repository.SessionRepository;
import org.sid.serviceanneeuniversitaire.repository.StructureRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
public class AnneeUniversitaireController {
    AnneeUniversitaireRepository anneeUniversitaireRepository;
    SemestreRepository semestreRepository;
    StructureRepository structureRepository;
    FiliereRestClient filiereRestClient;
    SessionRepository sessionRepository;

    public AnneeUniversitaireController(AnneeUniversitaireRepository anneeUniversitaireRepository, SemestreRepository semestreRepository, StructureRepository structureRepository, FiliereRestClient filiereRestClient, SessionRepository sessionRepository) {
        this.anneeUniversitaireRepository = anneeUniversitaireRepository;
        this.semestreRepository = semestreRepository;
        this.structureRepository = structureRepository;
        this.filiereRestClient = filiereRestClient;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping(path = "/anneeUniversitaire/{id}")
    public AnneeUniversitaire getAnneeUniversitaire(@PathVariable Long id){
        AnneeUniversitaire anneeUniversitaire=anneeUniversitaireRepository.findById(id).get();
        anneeUniversitaire.setSessions(null);
        anneeUniversitaire.setFilieres(null);
//        anneeUniversitaire.getFilieres().forEach(f->{
//            Filiere filiere=filiereRestClient.getFiliereById(f.getIdFiliere());
//            f.setFiliere(filiere);
//        });
        return anneeUniversitaire;
    }

    @GetMapping(path = "/anneeUniversitaires/{id}")
    public AnneeUniversitaire getAnneeUniversitaires(@PathVariable Long id){
        AnneeUniversitaire anneeUniversitaire=anneeUniversitaireRepository.findById(id).get();
        anneeUniversitaire.getFilieres().forEach(f->{
            Filiere filiere=filiereRestClient.getFiliereById(f.getIdFiliere());
            f.setFiliere(filiere);
        });
        return anneeUniversitaire;
    }

    @GetMapping(path = "/anneeUniversitaireCourante")
    public AnneeUniversitaire getAnneeUniversitaireCourante(){
        AnneeUniversitaire au = anneeUniversitaireRepository.findFirstByCouranteIsTrue();
        au.getFilieres().forEach(f->{
            Filiere filiere=filiereRestClient.getFiliereById(f.getIdFiliere());
            f.setFiliere(filiere);
        });
        au.getSessions().forEach(s->s.setSemestres(null));
        return au;
    }

    @GetMapping(path = "/{id}/semestres/{typeSession}/{nomFiliere}")
    public List<Semestre> getSemestre(@PathVariable("id") Long id, @PathVariable("typeSession") String typeSession,
                                            @PathVariable("nomFiliere") String nomFiliere ){
        AnneeUniversitaire au = anneeUniversitaireRepository.findById(id).get();
        System.out.println(1);
        Session session = au.getSessions().stream().filter(s->s.getTypeSession() == TypeSession.valueOf(typeSession)).findAny().orElse(null);
        Filiere filiere = filiereRestClient.getFiliereByNomFiliere(nomFiliere);
        List<Semestre> semestres = session.getSemestres().stream().filter(s->s.getIdFiliere() == filiere.getId()).collect(Collectors.toList());
        return semestres;
    }
}
