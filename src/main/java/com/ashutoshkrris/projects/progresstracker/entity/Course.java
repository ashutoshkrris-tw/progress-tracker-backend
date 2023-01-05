package com.ashutoshkrris.projects.progresstracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "course_details")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String link;

    private LocalDate startedOn;
    private LocalDate completedOn;
    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Progress> progressList;

    public Course() {
    }

    public Course(Long id, String name, String link, LocalDate startedOn, LocalDate completedOn, String status, List<Progress> progressList) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.startedOn = startedOn;
        this.completedOn = completedOn;
        this.status = status;
        this.progressList = progressList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDate getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDate startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDate getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDate completedOn) {
        this.completedOn = completedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Progress> getProgressList() {
        return progressList;
    }

    public void setProgressList(List<Progress> progressList) {
        this.progressList = progressList;
    }

}
