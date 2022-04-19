package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bandtito.models.Band;

public interface BandRepository extends JpaRepository<Band, String> {
    Band findByName(String name);
}