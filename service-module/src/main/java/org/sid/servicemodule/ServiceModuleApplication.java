package org.sid.servicemodule;

import org.sid.servicemodule.entities.Element;
import org.sid.servicemodule.entities.Module;
import org.sid.servicemodule.repositories.ElementRepository;
import org.sid.servicemodule.repositories.ModuleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ServiceModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceModuleApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ModuleRepository moduleRepository,
                            ElementRepository elementRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Module.class);
        return args -> {
            Module module1 = moduleRepository.save(new Module(null,"Machine Learning",10L,4,1L,null));
            Module module2 = moduleRepository.save(new Module(null,"Deep Learning",10L,4,1L,null));
            Module module3 = moduleRepository.save(new Module(null,"RC",10L,4,2L,null));


            elementRepository.save(new Element(null,"TP ML",2,module1));

            elementRepository.save(new Element(null,"Cours DL",2,module2));
            elementRepository.save(new Element(null,"TP DL",2,module2));

            elementRepository.save(new Element(null,"Cours RC",2,module3));
        };
    }
}
