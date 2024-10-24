package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "*") // Cho phép yêu cầu từ nguồn này
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
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {

        // Generate course code automatically
        String generatedCourseCode = generateCourseCode(course.getCourseName());
        course.setCourseCode(generatedCourseCode);

        Course existingCourse = iCourseService.createCourse(course);
        return ResponseEntity.ok(existingCourse);
    }

    private String generateCourseCode(String courseName) {
        // Extract the first character of each word in the course name
        String[] words = courseName.split(" ");
        StringBuilder code = new StringBuilder();
        for (String word : words) {
            code.append(word.charAt(0));
        }

        // Get the latest course ID to increment
        Long latestId = iCourseService.getLatestCourseId();
        int newId = latestId != null ? (int) (latestId + 1) : 1; // Increment the sequence

        // Generate the course code in the required format
        String courseCode = code.toString().toUpperCase() + String.format("%02d", newId);
        return courseCode;
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
