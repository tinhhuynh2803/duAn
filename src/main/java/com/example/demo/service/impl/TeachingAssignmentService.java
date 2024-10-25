package com.example.demo.service.impl;

import com.example.demo.model.TeachingAssignment;
import com.example.demo.repository.TeachingAssignmentRepository;
import com.example.demo.service.ITeachingAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingAssignmentService implements ITeachingAssignmentService {

    @Autowired
    private TeachingAssignmentRepository teachingAssignmentRepository;

    @Override
    public List<TeachingAssignment> getAllTeachingAssignment() {
        return teachingAssignmentRepository.findAll();
    }

    @Override
    public TeachingAssignment getTeachingAssignmentById(Long id) {
        return teachingAssignmentRepository.findById(id).orElseThrow();
    }

    @Override
    public TeachingAssignment createTeachingAssignment(TeachingAssignment teachingAssignment) {
        return teachingAssignmentRepository.save(teachingAssignment);
    }

    @Override
    public TeachingAssignment updateTeachingAssignment(Long id, TeachingAssignment teachingAssignment) {
        TeachingAssignment existingAssignment = getTeachingAssignmentById(id);
        // Cập nhật các trường ở đây
        return teachingAssignmentRepository.save(existingAssignment);
    }

    @Override
    public void deleteTeachingAssignment(Long id) {
        TeachingAssignment existingAssignment = getTeachingAssignmentById(id);
        teachingAssignmentRepository.delete(existingAssignment);
    }
}
