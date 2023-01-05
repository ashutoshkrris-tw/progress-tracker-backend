package com.ashutoshkrris.projects.progresstracker.service;

import com.ashutoshkrris.projects.progresstracker.entity.Course;
import com.ashutoshkrris.projects.progresstracker.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        List<Course> allCourses = courseRepository.findAll();
        return allCourses;
    }

    @Override
    public Course createNew(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void updateExisting(Long id, Course updatedCourse) {
        courseRepository.findById(id)
                .map(course -> {
                    course.setName(updatedCourse.getName());
                    course.setLink(updatedCourse.getLink());
                    course.setStartedOn(updatedCourse.getStartedOn());
                    course.setCompletedOn(updatedCourse.getCompletedOn());
                    course.setStatus(updatedCourse.getStatus());
                    course.setProgressList(updatedCourse.getProgressList());
                    return courseRepository.save(course);
                });
    }
}
