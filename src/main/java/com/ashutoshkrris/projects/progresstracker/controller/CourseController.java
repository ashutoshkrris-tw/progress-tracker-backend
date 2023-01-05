package com.ashutoshkrris.projects.progresstracker.controller;

import com.ashutoshkrris.projects.progresstracker.entity.Course;
import com.ashutoshkrris.projects.progresstracker.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PostMapping("/courses")
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        Course newCourse = courseService.createNew(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCourse.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            courseService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateTodo(@PathVariable Long id, @RequestBody Course course) {
        courseService.updateExisting(id, course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

}
