package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.BandAdmin;

public interface EmployerRepository extends JpaRepository<BandAdmin, String> {
    BandAdmin findByUuid(String uuid);
}