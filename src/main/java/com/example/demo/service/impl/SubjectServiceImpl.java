package com.example.demo.service.impl;

import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).orElseThrow();
    }

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Long id, Subject subject) {
        Subject subject1 = subjectRepository.findById(id).orElseThrow();
        subject1.setSubjectCode(subject.getSubjectCode());
        subject1.setSubjectName(subject.getSubjectName());
        subject1.setTheoryHours(subject.getTheoryHours());
        subject1.setPracticalHours(subject.getPracticalHours());
        subject1.setIsActive(subject.getIsActive());
        return subjectRepository.save(subject1);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
