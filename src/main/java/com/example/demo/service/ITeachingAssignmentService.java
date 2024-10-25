package com.example.demo.service;

import com.example.demo.model.TeachingAssignment;

import java.util.List;

public interface ITeachingAssignmentService {
    List<TeachingAssignment> getAllTeachingAssignment();
    TeachingAssignment getTeachingAssignmentById(Long id);
    TeachingAssignment createTeachingAssignment(TeachingAssignment teachingAssignment);
    TeachingAssignment updateTeachingAssignment(Long id, TeachingAssignment teachingAssignment);
    void deleteTeachingAssignment(Long id);
}