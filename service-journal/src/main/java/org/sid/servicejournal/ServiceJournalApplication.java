package org.sid.servicejournal;

import org.sid.servicejournal.entities.Journaliste;
import org.sid.servicejournal.repositories.ArticleRepository;
import org.sid.servicejournal.repositories.JournalisteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ServiceJournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJournalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(JournalisteRepository journalisteRepository,
                            ArticleRepository articleRepository,
                            RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Journaliste.class);
        return args -> {
        };
    }

}
