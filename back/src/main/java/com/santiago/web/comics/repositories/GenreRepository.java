package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Override
    Optional<Genre> findById(Long aLong);
}
