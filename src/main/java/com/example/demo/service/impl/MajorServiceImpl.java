package com.example.demo.service.impl;

import com.example.demo.model.Major;
import com.example.demo.repository.MajorRepository;
import com.example.demo.service.IMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements IMajorService {

    @Autowired
    private MajorRepository majorRepository;

    @Override
    public List<Major> getAllMajor() {
        return majorRepository.findAll();
    }

    @Override
    public Major getMajorById(Long id) {
        return majorRepository.findById(id).orElseThrow();
    }

    @Override
    public Major createMajor(Major major) {
        return majorRepository.save(major);
    }

    @Override
    public Major updateMajor(Long id, Major major) {
        Major existingMajor = majorRepository.findById(id).orElseThrow();
        existingMajor.setMajorName(major.getMajorName());
        return majorRepository.save(existingMajor);
    }

    @Override
    public void deleteMajor(Long id) {
        majorRepository.deleteById(id);
    }
}
