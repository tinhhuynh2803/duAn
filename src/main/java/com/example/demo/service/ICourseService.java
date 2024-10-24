package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    Long  getLatestCourseId();
    void deleteCourse(Long id);
}
