package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.bandtito.models.Employer;
import com.backend.bandtito.models.Job;

public interface JobRepository extends JpaRepository<Job, String> {
    Job findByName(String name);
    Job findByEmployer(Employer employer);
}