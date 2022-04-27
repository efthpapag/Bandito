package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.YearsOfExperience;

public interface YearsOfExperienceRepository extends JpaRepository<YearsOfExperience, String> {
    YearsOfExperience findByUuid(String uuid);
}