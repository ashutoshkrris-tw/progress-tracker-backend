package com.ashutoshkrris.projects.progresstracker.service;

import com.ashutoshkrris.projects.progresstracker.entity.Course;
import com.ashutoshkrris.projects.progresstracker.entity.Progress;

import java.util.List;

public interface ProgressService {
    List<Progress> getProgress(Course course);

    Progress getProgressById(Course course, Long progressId);

    Progress createProgress(Course course, Progress progress);

    Progress updateExisting(Course course, Long progressId, Progress updatedProgress);

    void deleteById(Long progressId);
}
