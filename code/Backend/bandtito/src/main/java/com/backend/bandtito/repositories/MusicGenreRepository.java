package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.MusicGenre;

public interface MusicGenreRepository extends JpaRepository<MusicGenre, String> {
    MusicGenre findByName(String name);
}