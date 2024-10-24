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
@CrossOrigin(origins = "http://localhost:3000") // Cho phép yêu cầu từ nguồn này
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

    @PostMapping()
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        System.out.println("Received course: " + course);
        // Tạo mã khóa học tự động
//        String generatedCourseCode = generateCourseCode(course.getCourseName());
//        course.setCourseCode(generatedCourseCode);

//        Course existingCourse = iCourseService.createCourse(course);
        return ResponseEntity.ok(course);
    }

    private String generateCourseCode(String courseName) {
        // Lấy các ký tự đầu tiên của tên khóa học
        String[] words = courseName.split(" ");
        StringBuilder code = new StringBuilder();
        for (String word : words) {
            code.append(word.charAt(0));
        }

        // Lấy số thứ tự mới nhất để tăng dần
        Long latestId = iCourseService.getLatestCourseId(); // Bạn cần tạo phương thức này trong service để lấy id lớn nhất
        int newId = latestId != null ? (int)(latestId + 1) : 1; // Tăng số thứ tự lên 1

        // Tạo mã khóa học với định dạng yêu cầu
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
