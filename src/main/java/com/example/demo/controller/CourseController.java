package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:3000")
 // Cho phép yêu cầu từ nguồn này
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
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        try {
            String generatedCourseCode = generateCourseCode(course.getCourseName());
            course.setCourseCode(generatedCourseCode);

            Course existingCourse = iCourseService.createCourse(course);
            return ResponseEntity.ok(existingCourse);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Course code already exists.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }


    private String generateCourseCode(String courseName) {
        // Tạo mã từ các ký tự đầu tiên của các từ trong tên khóa học
        String[] words = courseName.split(" ");
        StringBuilder code = new StringBuilder();
        for (String word : words) {
            code.append(word.charAt(0));
        }

        // Lấy ID khóa học mới nhất
        Long latestId = iCourseService.getLatestCourseId();
        int newId = latestId != null ? (int) (latestId + 1) : 1; // Tăng ID

        // Tạo mã khóa học
        return code.toString().toUpperCase() + String.format("%02d", newId);
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
