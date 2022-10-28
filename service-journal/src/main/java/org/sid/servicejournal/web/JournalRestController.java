package org.sid.servicejournal.web;

import org.sid.servicejournal.entities.Article;
import org.sid.servicejournal.entities.Journaliste;
import org.sid.servicejournal.repositories.ArticleRepository;
import org.sid.servicejournal.repositories.JournalisteRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
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
        Collection<Journaliste> journalistes =  journalisteRepository.findAll();
        journalistes.forEach(j->j.setArticles(null));
        return journalistes;
    }

    @PostMapping("/ajouterJournaliste")
    public Journaliste insertJournaliste(@RequestBody Journaliste journaliste){
        return journalisteRepository.save(journaliste);
    }

    @PutMapping("/modifieJournaliste")
    public Journaliste editArticle(@RequestBody Journaliste journaliste){
        return journalisteRepository.save(journaliste);
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    @GetMapping("/articles/idJournaliste/{id}")
    public Collection<Article> getArticles(@PathVariable Long id){
        return articleRepository.findAllByJournalisteId(id);
    }

    @PostMapping(value = "/ajouterArticle", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Article insertArticle(@RequestPart("article") Article article,
                                 @RequestPart("contenuArticle") MultipartFile contenuArticle) throws IOException{
        article.setContenu(contenuArticle.getBytes());
        return articleRepository.save(article);
    }

    @PutMapping(value = "/modifieArticle", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Article editArticle(@RequestPart("article") Article article,
                               @RequestPart("contenuArticle") MultipartFile contenuArticle) throws IOException{
        if(contenuArticle!=null){
            article.setContenu(contenuArticle.getBytes());
        }else{
            Article a = articleRepository.findById(article.getId()).get();
            article.setContenu(a.getContenu());
        }
        return articleRepository.save(article);
    }

    @DeleteMapping("/supprimerArticle/")
    public void deletArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
    }

    @GetMapping("/downloadContenu/{id}")
    public void downloadContenuArticle(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Article article = articleRepository.findById(id).get();

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename="+ article.getTitre() +" - "+ article.getAuteur() +".pdf";

        response.setHeader(headerKey,headerValue);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(article.getContenu());
        servletOutputStream.close();
    }
}
