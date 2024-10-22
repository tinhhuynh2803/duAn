package com.example.demo.service;

import com.example.demo.model.RegisterCourse;

import java.util.List;

public interface IRegisterCourseService {

    public List<RegisterCourse> getAllRegisterCourse();
    public RegisterCourse getRegisterCourseById(Long id);
    public RegisterCourse createRegisterCourse(RegisterCourse registerCourse);
    public RegisterCourse updateRegisterCourse(Long id, RegisterCourse registerCourse);
    public void deleteRegisterCourse(Long id);
}
