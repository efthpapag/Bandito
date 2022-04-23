package com.backend.bandtito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.bandtito.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}