package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, String> {
    Instrument findByName(String name);
}