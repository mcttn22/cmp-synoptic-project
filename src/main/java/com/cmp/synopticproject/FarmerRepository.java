package com.cmp.synopticproject;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to define queries for farmer entity.
 */
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {}

