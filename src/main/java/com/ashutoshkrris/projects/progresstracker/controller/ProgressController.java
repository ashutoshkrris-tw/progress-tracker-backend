package com.ashutoshkrris.projects.progresstracker.controller;

import com.ashutoshkrris.projects.progresstracker.entity.Course;
import com.ashutoshkrris.projects.progresstracker.entity.Progress;
import com.ashutoshkrris.projects.progresstracker.service.CourseServiceImpl;
import com.ashutoshkrris.projects.progresstracker.service.ProgressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProgressController {

    @Autowired
    private ProgressServiceImpl progressService;

    @Autowired
    private CourseServiceImpl courseService;


    @GetMapping("/courses/{id}/progress")
    public List<Progress> retrieveProgress(@PathVariable Long id) {
        Course course = courseService.getById(id);
        if (course == null) {
            throw new RuntimeException("Course Not Found");
        }
        return progressService.getProgress(course);
    }

    @GetMapping("/courses/{courseId}/progress/{progressId}")
    public Progress retrieveProgressById(@PathVariable Long courseId, @PathVariable Long progressId) {
        Course course = courseService.getById(courseId);
        if (course == null) {
            throw new RuntimeException("Course Not Found");
        }
        return progressService.getProgressById(course, progressId);
    }


    @PostMapping("/courses/{id}/progress")
    public ResponseEntity<Progress> addProgress(@PathVariable Long id, @RequestBody Progress progress) {
        Course course = courseService.getById(id);
        if (course == null) {
            throw new RuntimeException("Course Not Found");
        }
        Progress savedProgress = progressService.createProgress(course, progress);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProgress.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/courses/{courseId}/progress/{progressId}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long courseId, @PathVariable Long progressId, @RequestBody Progress updatedProgress) {
        Course course = courseService.getById(courseId);
        if (course == null) {
            throw new RuntimeException("Course Not Found");
        }
        progressService.updateExisting(course, progressId, updatedProgress);
        return new ResponseEntity<>(updatedProgress, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseId}/progress/{progressId}")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long courseId, @PathVariable Long progressId) {
        Course course = courseService.getById(courseId);
        if (course == null) {
            throw new RuntimeException("Course Not Found");
        }
        progressService.deleteById(progressId);
        return ResponseEntity.noContent().build();
    }

}
