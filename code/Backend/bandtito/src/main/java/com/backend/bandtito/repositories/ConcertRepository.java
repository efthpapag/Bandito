package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

import com.backend.bandtito.models.Concert;

public interface ConcertRepository extends JpaRepository<Concert, LocalDate> {
    Concert findByDate(LocalDate date);
}