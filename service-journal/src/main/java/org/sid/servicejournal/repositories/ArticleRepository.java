package org.sid.servicejournal.repositories;

import org.sid.servicejournal.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article,Long> {
    public Collection<Article> findAllByJournalisteId(Long id);
}
