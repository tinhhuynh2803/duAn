package com.example.demo.controller;

import com.example.demo.model.Subject;
import com.example.demo.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private ISubjectService iSubjectService;

    @GetMapping
    public List<Subject> getAllSubject(){
        return iSubjectService.getAllSubject();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id){
        Subject subject = iSubjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        Subject subject1 = iSubjectService.createSubject(subject);
        return ResponseEntity.ok(subject1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject){
        Subject subject1 = iSubjectService.updateSubject(id, subject);
        return ResponseEntity.ok(subject1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id){
        iSubjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
