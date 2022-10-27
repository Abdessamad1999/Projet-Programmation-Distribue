package org.sid.serviceanneeuniversitaire;

import org.sid.serviceanneeuniversitaire.entities.*;
import org.sid.serviceanneeuniversitaire.enumerations.Type;
import org.sid.serviceanneeuniversitaire.enumerations.TypeSession;
import org.sid.serviceanneeuniversitaire.feign.FiliereRestClient;
import org.sid.serviceanneeuniversitaire.model.Filiere;
import org.sid.serviceanneeuniversitaire.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class ServiceAnneeUniversitaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAnneeUniversitaireApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AnneeUniversitaireRepository anneeUniversitaireRepository, SessionRepository sessionRepository,
                            SemestreRepository semestreRepository, TypeSemestreRepository typeSemestreRepository,
                            StructureRepository structureRepository, FiliereRestClient filiereRestClient,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(AnneeUniversitaire.class, FiliereAnneeUniversitaire.class, Session.class, Semestre.class, TypeSemestre.class);
        return args -> {

//            Collection<Filiere> filieres=filiereRestClient.getFilieresDepartement(1L);
//
//            List<FiliereAnneeUniversitaire> filiereAnneeUniversitairesList=new ArrayList<>();
//
//            filieres.forEach(f->{
//                FiliereAnneeUniversitaire filiereAnneeUniversitaire=structureRepository.save(new FiliereAnneeUniversitaire(null,f.getId(),null,null));
//                filiereAnneeUniversitairesList.add(filiereAnneeUniversitaire);
//            });
//
//            Session sessionAutomne=sessionRepository.save(new Session(null, TypeSession.Automne,null,null));
//            Session sessionPrintemps=sessionRepository.save(new Session(null, TypeSession.Printemps,null,null));
//
//            List<Session> sessionList=new ArrayList<>();
//            sessionList.add(sessionAutomne);
//            sessionList.add(sessionPrintemps);
//
//            AnneeUniversitaire anneeUniversitaire=anneeUniversitaireRepository.save(new AnneeUniversitaire(null,"2022-2023",true,sessionList,filiereAnneeUniversitairesList));
//            filiereAnneeUniversitairesList.forEach(f->{
//                f.setAnneeUniversitaire(anneeUniversitaire);
//                structureRepository.save(f);
//            });
//
//            TypeSemestre semestreOrdinaire=typeSemestreRepository.save(new TypeSemestre(null, Type.Ordinnaire,null));
//            TypeSemestre semestreRattrapage=typeSemestreRepository.save(new TypeSemestre(null, Type.Ratrrapage,null));
//            List<TypeSemestre> typeSemestres=new ArrayList<>();
//            typeSemestres.add(semestreOrdinaire);
//            typeSemestres.add(semestreRattrapage);
//
//
//
//            filieres.forEach(f->{
//                int nbAnneeFiliere= f.getNombreSemestres();
//
//                for (int i=0;i<nbAnneeFiliere;i++){
//                    List<Semestre> semestresAutomne=new ArrayList<Semestre>();
//                    List<Semestre> semestresPreintemps=new ArrayList<Semestre>();
//
//                    if(i%2==0){
//                        int a=i+1;
//                        String nomSemestre = String.format("S%s",a);
//                        //Semestre Ordinaire et rattrappage de chaque filiere sessionAutomne
//                        Semestre semestreOrd=new Semestre(null,nomSemestre,f.getId(),typeSemestres,sessionAutomne);
//                        semestresAutomne.add(semestreOrd);
//                        semestreRepository.save(semestreOrd);
//                    }
//                    else {
//                        int a=i+1;
//                        String nomSemestre = String.format("S%s",a);
//                        //Semestre Ordinaire et rattrappage de chaque filiere sessionAutomne
//                        Semestre semestreOrd=new Semestre(null,nomSemestre,f.getId(),typeSemestres,sessionPrintemps);
//                        semestresPreintemps.add(semestreOrd);
//                        semestreRepository.save(semestreOrd);
//                    }
//
//                    typeSemestres.forEach(t->{
//                        t.setSemestres(semestresAutomne);
//                        typeSemestreRepository.save(t);
//                    });
//
//                    typeSemestres.forEach(t->{
//                        t.setSemestres(semestresPreintemps);
//                        typeSemestreRepository.save(t);
//
//                    });
//
//                    sessionAutomne.setSemestres(semestresAutomne);
//                    sessionPrintemps.setSemestres(semestresPreintemps);
//
//                    sessionRepository.save(sessionAutomne);
//                    sessionRepository.save(sessionPrintemps);
//                }
//
//            });
//
//
//            sessionList.forEach(s->{
//                s.setAnneeUniversitaire(anneeUniversitaire);
//                sessionRepository.save(s);
//            });


        };
    }
}

