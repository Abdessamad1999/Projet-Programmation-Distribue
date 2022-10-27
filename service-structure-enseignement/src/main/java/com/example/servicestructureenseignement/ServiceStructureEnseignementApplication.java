package com.example.servicestructureenseignement;

import com.example.servicestructureenseignement.etities.Filiere;
import com.example.servicestructureenseignement.fiegn.ModuleRestClient;
import com.example.servicestructureenseignement.repositories.FiliereRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
public class ServiceStructureEnseignementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStructureEnseignementApplication.class, args);
    }

    @Bean
    CommandLineRunner start(FiliereRepository filiereRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Filiere.class);
        return args -> {
            filiereRepository.save(new Filiere(null,"SMI",3,6,0,0,1L,"Ali Bekri",null));
            filiereRepository.save(new Filiere(null,"SMA",3,6,0,0,1L,"Mohamed Zitane",null));
        };
    }

}
