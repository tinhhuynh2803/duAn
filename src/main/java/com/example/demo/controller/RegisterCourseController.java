package com.example.demo.controller;

import com.example.demo.model.RegisterCourse;
import com.example.demo.service.IRegisterCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registercourse")
public class RegisterCourseController {

    @Autowired
    private IRegisterCourseService iRegisterCourseService;

    @GetMapping
    public List<RegisterCourse> getAllRegisterCourse(){
        return iRegisterCourseService.getAllRegisterCourse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterCourse> getRegisterCourseById(@PathVariable Long id){
        RegisterCourse registerCourse = iRegisterCourseService.getRegisterCourseById(id);
        return ResponseEntity.ok(registerCourse);
    }

    @PostMapping
    public ResponseEntity<RegisterCourse> createRegisterCourse(@RequestBody RegisterCourse registerCourse){
        RegisterCourse createRegisterCourse = iRegisterCourseService.createRegisterCourse(registerCourse);
        return ResponseEntity.ok(createRegisterCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterCourse> updateRegisterCourse(@PathVariable Long id, @RequestBody RegisterCourse registerCourse){
        RegisterCourse updateRegisterCourse = iRegisterCourseService.updateRegisterCourse(id, registerCourse);
        return ResponseEntity.ok(updateRegisterCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegisterCourse> deleteRegisterCourse(@PathVariable Long id){
        iRegisterCourseService.deleteRegisterCourse(id);
        return ResponseEntity.noContent().build();
    }
}
