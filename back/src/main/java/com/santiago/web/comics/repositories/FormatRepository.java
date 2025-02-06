package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Format;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormatRepository extends JpaRepository<Format, Long> {
    @Override
    Optional<Format> findById(Long aLong);
    Optional<Format> findByName(String name);

}
