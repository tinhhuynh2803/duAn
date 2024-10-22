package com.example.demo.service.impl;

import com.example.demo.model.RegisterCourse;
import com.example.demo.repository.RegisterCourseRepository;
import com.example.demo.service.IRegisterCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterCourseServiceImpl implements IRegisterCourseService {

    @Autowired
    private RegisterCourseRepository registerCourseRepository;

    @Override
    public List<RegisterCourse> getAllRegisterCourse() {
        return registerCourseRepository.findAll();
    }

    @Override
    public RegisterCourse getRegisterCourseById(Long id) {
        return registerCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public RegisterCourse createRegisterCourse(RegisterCourse registerCourse) {
        return registerCourseRepository.save(registerCourse);
    }

    @Override
    public RegisterCourse updateRegisterCourse(Long id, RegisterCourse registerCourse) {
        RegisterCourse existingRegisterCourse = registerCourseRepository.findById(id).orElseThrow();
        existingRegisterCourse.setRegistrationDate(registerCourse.getRegistrationDate());
        return registerCourseRepository.save(existingRegisterCourse);
    }

    @Override
    public void deleteRegisterCourse(Long id) {
        registerCourseRepository.deleteById(id);
    }
}
