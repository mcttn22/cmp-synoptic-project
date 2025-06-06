package com.cmp.synopticproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to define queries for toilet entity.
 */
public interface ToiletRepository extends JpaRepository<Toilet, Integer> {
	List<Toilet> findAllByBlockId(Integer blockId);
}

