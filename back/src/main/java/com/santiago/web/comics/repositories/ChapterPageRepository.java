package com.santiago.web.comics.repositories;

import com.santiago.web.comics.entities.ChapterPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterPageRepository extends JpaRepository<ChapterPage, Long> {
}
