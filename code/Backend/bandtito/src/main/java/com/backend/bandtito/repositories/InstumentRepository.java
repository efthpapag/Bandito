package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.Instument;



public interface InstumentRepository extends JpaRepository<Instument, String> {
    Instument findByName(String name);
}