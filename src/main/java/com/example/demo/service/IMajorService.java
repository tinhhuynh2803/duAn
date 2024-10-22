package com.example.demo.service;

import com.example.demo.model.Major;

import java.util.List;

public interface IMajorService {

    public List<Major> getAllMajor();
    public Major getMajorById(Long id);
    public Major createMajor(Major major);
    public Major updateMajor(Long id, Major major);
    public void deleteMajor(Long id);
}
