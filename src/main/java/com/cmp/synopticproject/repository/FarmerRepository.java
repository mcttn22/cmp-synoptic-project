package com.cmp.synopticproject.repository;

import com.cmp.synopticproject.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to define queries for farmer entity.
 */
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
	boolean existsByResId (Integer resId);
}

