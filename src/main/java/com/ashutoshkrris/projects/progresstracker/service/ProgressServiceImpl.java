package com.ashutoshkrris.projects.progresstracker.service;

import com.ashutoshkrris.projects.progresstracker.entity.Course;
import com.ashutoshkrris.projects.progresstracker.entity.Progress;
import com.ashutoshkrris.projects.progresstracker.repository.CourseRepository;
import com.ashutoshkrris.projects.progresstracker.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Progress> getProgress(Course course) {
        List<Progress> progressList = course.getProgressList();
        Comparator<Progress> dateComparator = (p1, p2) -> p2.getDate().compareTo(p1.getDate());
        progressList.sort(dateComparator);
        return progressList;
    }

    @Override
    public Progress getProgressById(Course course, Long progressId) {
        List<Progress> progressList = course.getProgressList();
        for (Progress progress : progressList) {
            if (progress.getId().equals(progressId))
                return progress;
        }
        return null;
    }

    @Override
    public Progress createProgress(Course course, Progress progress) {
        progress.setCourse(course);
        return progressRepository.save(progress);
    }

    @Override
    public Progress updateExisting(Course course, Long progressId, Progress updatedProgress) {
        List<Progress> progressList = course.getProgressList();
        Progress progressFromDb = null;
        for (Progress progress : progressList) {
            if (progress.getId().equals(progressId))
                progressFromDb = progress;
        }
        assert progressFromDb != null;
        progressFromDb.setDescription(updatedProgress.getDescription());
        progressFromDb.setDate(updatedProgress.getDate());
        return progressRepository.save(progressFromDb);
    }

    @Override
    public void deleteById(Long progressId) {
        progressRepository.deleteById(progressId);
    }
}
