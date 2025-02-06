package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Demographic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemographicRepository extends JpaRepository<Demographic, Long> {
    @Override
    Optional<Demographic> findById(Long aLong);
    Optional<Demographic> findByName(String name);

}
