package org.sid.serviceetablissement;

import org.sid.serviceetablissement.entities.Departement;
import org.sid.serviceetablissement.entities.Etablissement;
import org.sid.serviceetablissement.repositories.DepartementRepository;
import org.sid.serviceetablissement.repositories.EtablissementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ServiceEtablissementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceEtablissementApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EtablissementRepository etablissementRepository,
                            DepartementRepository departementRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Etablissement.class,Departement.class);
        return args -> {
            Etablissement e = etablissementRepository.save(new Etablissement(null,"Faculté des sciences de meknès","FS",null,"nom1",null));
            etablissementRepository.save(new Etablissement(null,"Faculté des sciences juridiques économiques et sociales de meknès","FSJES",null,"nom2",null));
            departementRepository.save(new Departement(null,"Informatique","chef1",e));
            departementRepository.save(new Departement(null,"Mathematique","chef2",e));
        };
    }
}
