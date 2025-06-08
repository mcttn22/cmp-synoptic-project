package com.cmp.synopticproject.repository;

import com.cmp.synopticproject.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to define queries for report entity.
 */
public interface ReportRepository extends JpaRepository<Report, Integer> {}

