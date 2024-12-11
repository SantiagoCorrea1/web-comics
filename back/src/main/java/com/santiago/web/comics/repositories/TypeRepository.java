package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    @Override
    Optional<Type> findById(Long aLong);
}
