package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Author;
import com.santiago.web.comics.models.entities.Comic;
import com.santiago.web.comics.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {

        Optional<Comic>findByUrl(String url);
        Optional<Set<Comic>>findAllByAuthors(Author author);

        Optional<Set<Comic>>findAllByGenres(Set<Genre> genres);
}
