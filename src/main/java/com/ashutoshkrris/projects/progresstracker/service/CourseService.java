package com.ashutoshkrris.projects.progresstracker.service;

import com.ashutoshkrris.projects.progresstracker.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();

    Course createNew(Course course);

    Course getById(Long id);

    void deleteById(Long id);

    void updateExisting(Long id, Course updatedCourse);
}
