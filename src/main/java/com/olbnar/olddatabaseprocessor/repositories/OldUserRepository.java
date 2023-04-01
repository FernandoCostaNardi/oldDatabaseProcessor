package com.olbnar.olddatabaseprocessor.repositories;

import com.olbnar.olddatabaseprocessor.models.OldUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldUserRepository extends JpaRepository<OldUser, Long> {
}
