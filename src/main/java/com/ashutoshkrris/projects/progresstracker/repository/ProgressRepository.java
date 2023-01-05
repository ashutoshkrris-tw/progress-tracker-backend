package com.ashutoshkrris.projects.progresstracker.repository;

import com.ashutoshkrris.projects.progresstracker.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
