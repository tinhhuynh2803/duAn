package com.example.demo.service;

import com.example.demo.model.DegreeLevel;

import java.util.List;

public interface IDegreeLevelService {

    public List<DegreeLevel> getAllDegreeLevel();
    public DegreeLevel getDegreeLevelById(Long id);
    public DegreeLevel createDegreeLevel(DegreeLevel degreeLevel);
    public DegreeLevel updateDegreeLevel(Long id, DegreeLevel degreeLevel);
    public void deleteDegreeLevel(Long id);
}
