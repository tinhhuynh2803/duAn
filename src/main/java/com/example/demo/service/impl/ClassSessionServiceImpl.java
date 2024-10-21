package com.example.demo.service.impl;

import com.example.demo.model.ClassSession;
import com.example.demo.repository.ClassSessionRepository;
import com.example.demo.service.IClassSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassSessionServiceImpl implements IClassSessionService {

    @Autowired
    private ClassSessionRepository classSessionRepository;

    @Override
    public List<ClassSession> getAllClassSessions() {
        return classSessionRepository.findAll();
    }

    @Override
    public ClassSession getClassSessionById(Long id) {
        return classSessionRepository.findById(id).orElseThrow();
    }

    @Override
    public ClassSession createClassSession(ClassSession classSession) {
        return classSessionRepository.save(classSession);
    }

    @Override
    public ClassSession updateClassSession(Long id, ClassSession classSession) {
        ClassSession existingClassSession = classSessionRepository.findById(id).orElseThrow();
        return classSessionRepository.save(existingClassSession);
    }

    @Override
    public void deleteClassSession(Long id) {
        classSessionRepository.deleteById(id);
    }
}
