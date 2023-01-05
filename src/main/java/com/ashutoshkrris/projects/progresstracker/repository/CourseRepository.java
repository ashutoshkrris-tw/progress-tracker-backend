package com.ashutoshkrris.projects.progresstracker.repository;

import com.ashutoshkrris.projects.progresstracker.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
