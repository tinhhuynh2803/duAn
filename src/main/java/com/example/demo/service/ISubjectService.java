package com.example.demo.service;

import com.example.demo.model.Subject;

import java.util.List;

public interface ISubjectService {

    public List<Subject> getAllSubject();
    public Subject getSubjectById(Long id);
    public Subject createSubject(Subject subject);
    public Subject updateSubject(Long id, Subject subject);
    public void deleteSubject(Long id);
}
