package com.santiago.web.comics.repositories;

import com.santiago.web.comics.models.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status,Long> {

    @Override
    Optional<Status> findById(Long aLong);
}
