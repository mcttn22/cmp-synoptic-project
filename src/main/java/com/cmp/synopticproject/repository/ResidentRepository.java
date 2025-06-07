package com.cmp.synopticproject.repository;

import java.util.Optional;

import com.cmp.synopticproject.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to define queries for resident entity.
 */
public interface ResidentRepository extends JpaRepository<Resident, Integer> {
	boolean existsByUsername (String username);
	Optional<Resident> findByUsername (String username);
}

