package com.example.demo.service;

import com.example.demo.model.ClassSession;

import java.util.List;

public interface IClassSessionService {
    List<ClassSession> getAllClassSessions();
    ClassSession getClassSessionById(Long id);
    ClassSession createClassSession(ClassSession classSession);
    ClassSession updateClassSession(Long id, ClassSession classSession);
    void deleteClassSession(Long id);
}
