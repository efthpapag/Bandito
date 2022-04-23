package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.BandPosition;

public interface BandPositionRepository extends JpaRepository<BandPosition, String> {
    BandPosition findByName(String name);
}