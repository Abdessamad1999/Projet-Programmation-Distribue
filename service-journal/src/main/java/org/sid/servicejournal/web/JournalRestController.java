package org.sid.servicejournal.web;

import org.sid.servicejournal.entities.Article;
import org.sid.servicejournal.entities.Journaliste;
import org.sid.servicejournal.repositories.ArticleRepository;
import org.sid.servicejournal.repositories.JournalisteRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
public class JournalRestController {
    private JournalisteRepository journalisteRepository;
    private ArticleRepository articleRepository;


    public JournalRestController(JournalisteRepository journalisteRepository,ArticleRepository articleRepository){
        this.journalisteRepository = journalisteRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/journalistes")
    public Collection<Journaliste> getAllJournaliste(){
        return journalisteRepository.findAll();
    }

    @PostMapping("/ajouterJournaliste")
    public Journaliste insertJournaliste(@RequestBody Journaliste journaliste){
        return journalisteRepository.save(journaliste);
    }

    @PutMapping("/modifieJournaliste")
    public Journaliste editArticle(@RequestBody Journaliste journaliste){
        return journalisteRepository.save(journaliste);
    }

    @GetMapping("/articles/idJournaliste/{id}")
    public Collection<Article> getArticles(@PathVariable Long id){
        return articleRepository.findAllByJournalisteId(id);
    }

    @PostMapping("/ajouterArticle")
    public Article insertArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }

    @PutMapping("/uploadArticle/{id}")
    public Article uploadArticle(@PathVariable("id") Long id, @RequestParam("contenuArticle") MultipartFile contenuArticle) throws IOException {
        Article article = articleRepository.findById(id).get();
        article.setContenu(contenuArticle.getBytes());
        return articleRepository.save(article);
    }

    @PutMapping("/modifieArticle")
    public Article editArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }

    @DeleteMapping("/supprimerArticle/")
    public void deletArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
    }
}
