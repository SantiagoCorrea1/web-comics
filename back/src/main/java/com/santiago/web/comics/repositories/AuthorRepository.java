package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    Optional<Author> findById(Long aLong);
    Optional<Author> findByName(String name);

}
