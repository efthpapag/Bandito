package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bandtito.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
    Rating findByUuid(String uuid);
}
