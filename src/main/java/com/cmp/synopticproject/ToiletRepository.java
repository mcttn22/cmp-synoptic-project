package com.cmp.synopticproject;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to represent database via ORM.
 */
public interface ToiletRepository extends JpaRepository<Toilet, Integer> {}

