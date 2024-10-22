package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService iCourseService;

    @GetMapping
    public List<Course> getAllCourse(){
        return iCourseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        Course course = iCourseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course existingCourse = iCourseService.createCourse(course);
        return ResponseEntity.ok(existingCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course){
        Course course1 = iCourseService.updateCourse(id, course);
        return ResponseEntity.ok(course1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        iCourseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
