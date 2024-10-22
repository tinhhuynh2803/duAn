package com.example.demo.service.impl;

import com.example.demo.model.DegreeLevel;
import com.example.demo.repository.DegreeLevelRepository;
import com.example.demo.service.IDegreeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeLevelServiceImpl implements IDegreeLevelService {

    @Autowired
    private DegreeLevelRepository degreeLevelRepository;

    @Override
    public List<DegreeLevel> getAllDegreeLevel() {
        return degreeLevelRepository.findAll();
    }

    @Override
    public DegreeLevel getDegreeLevelById(Long id) {
        return degreeLevelRepository.findById(id).orElseThrow();
    }

    @Override
    public DegreeLevel createDegreeLevel(DegreeLevel degreeLevel) {
        return degreeLevelRepository.save(degreeLevel);
    }

    @Override
    public DegreeLevel updateDegreeLevel(Long id, DegreeLevel degreeLevel) {
        DegreeLevel existingDegreeLevel = degreeLevelRepository.findById(id).orElseThrow();
        existingDegreeLevel.setQualificationName(degreeLevel.getQualificationName());
        existingDegreeLevel.setNote(degreeLevel.getNote());
        return degreeLevelRepository.save(existingDegreeLevel);
    }

    @Override
    public void deleteDegreeLevel(Long id) {
        degreeLevelRepository.deleteById(id);
    }
}
