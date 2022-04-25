package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bandtito.models.Concert;

public interface ConcertRepository extends JpaRepository<Concert, String> {
    Concert findByUuid(String uuid);
}