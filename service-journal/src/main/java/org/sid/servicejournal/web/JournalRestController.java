package org.sid.servicejournal.web;

import org.sid.servicejournal.entities.Article;
import org.sid.servicejournal.entities.Journaliste;
import org.sid.servicejournal.repositories.ArticleRepository;
import org.sid.servicejournal.repositories.JournalisteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class JournalRestController {
    private JournalisteRepository journalisteRepository;
    private ArticleRepository articleRepository;


    public JournalRestController(JournalisteRepository journalisteRepository,ArticleRepository articleRepository){
        this.journalisteRepository = journalisteRepository;
        this.articleRepository = articleRepository;
    }

    @PostMapping("/ajouterJournaliste")
    public void insertJournaliste(@RequestParam String nom, @RequestParam String prenom,
                                  @RequestParam String email, @RequestParam String profil){
        Journaliste j = new Journaliste();
        j.setNom(nom);
        j.setPrenom(prenom);
        j.setEmail(email);
        j.setProfil(profil);

        journalisteRepository.save(j);
    }

    @GetMapping("/articles/{id}")
    public Collection<Article> getArticles(@PathVariable Long id){
        Collection<Article> articles = new ArrayList<Article>();
        if(id == null) {
            articles = articleRepository.findAll();
        }else{
            articles = articleRepository.findAllByJournalisteId(id);
        }
        return articles;
    }

    @PostMapping("/ajouterArticle")
    public void insertArticle(@RequestParam String titre, @RequestParam String contenu,
                              @RequestParam String auteurs,@RequestParam Long id){
        Article a = new Article();
        a.setTitre(titre);
        a.setContenu(contenu);
        a.setAuteurs(auteurs);
        Journaliste j = new Journaliste();
        j.setId(id);
        a.setJournaliste(j);

        articleRepository.save(a);
    }

    @PostMapping("/modifieArticle")
    public void editArticle(@RequestParam String titre, @RequestParam String contenu,
                            @RequestParam String auteurs,@RequestParam Long idArticle){
        Article a = articleRepository.findById(idArticle).get();
        a.setTitre(titre);
        a.setAuteurs(auteurs);
        a.setContenu(contenu);

        articleRepository.save(a);
    }

    @PostMapping("/supprimerArticle")
    public void deletArticle(@RequestParam Long id){
        articleRepository.deleteById(id);
    }
}
