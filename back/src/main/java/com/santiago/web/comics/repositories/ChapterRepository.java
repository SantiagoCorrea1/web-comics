package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Chapter;
import com.santiago.web.comics.models.entities.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    Optional<Chapter> findById(Long id);
    Optional<Chapter> findByChapterNumberAndComic(int chapter, Comic comic);

    Optional<Set<Chapter>> findAllByComic(Comic comic);

}
