package com.example.demo.controller;

import com.example.demo.model.TeachingAssignment;
import com.example.demo.service.ITeachingAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachingassignment")
public class TeachingAssignmentController {

    @Autowired
    private ITeachingAssignmentService iTeachingAssignmentService;

    @GetMapping
    public List<TeachingAssignment> getAllTeachingAssignment(){
        System.out.println("err: ");
        return iTeachingAssignmentService.getAllTeachingAssignment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachingAssignment> getTeachingAssignmentById(@PathVariable Long id){
        TeachingAssignment teachingAssignment = iTeachingAssignmentService.getTeachingAssignmentById(id);
        return ResponseEntity.ok(teachingAssignment);
    }

    @PostMapping
    public ResponseEntity<TeachingAssignment> createTeachingAssignment(@RequestBody TeachingAssignment teachingAssignment){
        TeachingAssignment createTeachingAssignment = iTeachingAssignmentService.createTeachingAssignment(teachingAssignment);
        return ResponseEntity.ok(createTeachingAssignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachingAssignment> updateTeachingAssignment(@PathVariable Long id, @RequestBody TeachingAssignment teachingAssignment){
        TeachingAssignment updateTeachingAssignment = iTeachingAssignmentService.updateTeachingAssignment(id, teachingAssignment);
        return ResponseEntity.ok(updateTeachingAssignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TeachingAssignment> deleteTeachingAssignment(@PathVariable Long id){
        iTeachingAssignmentService.deleteTeachingAssignment(id);
        return ResponseEntity.noContent().build();
    }
}