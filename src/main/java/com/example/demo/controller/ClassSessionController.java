package com.example.demo.controller;

import com.example.demo.model.ClassSession;
import com.example.demo.service.IClassSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-session")
public class ClassSessionController {

    @Autowired
    private IClassSessionService iClassSessionService;

    @GetMapping
    public List<ClassSession> getAllClassSession(){
        return iClassSessionService.getAllClassSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSession> getClassSessionById(@PathVariable Long id){
        ClassSession classSession = iClassSessionService.getClassSessionById(id);
        return ResponseEntity.ok(classSession);
    }

    @PostMapping
    public ResponseEntity<ClassSession> createClassSession(@RequestBody ClassSession classSession){
        ClassSession createClassSession = iClassSessionService.createClassSession(classSession);
        return ResponseEntity.ok(createClassSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSession> updateClassSession(@PathVariable Long id, @RequestBody ClassSession classSession){
        ClassSession updateClassSession = iClassSessionService.updateClassSession(id, classSession);
        return ResponseEntity.ok(updateClassSession);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassSession> deleteClassSession(@PathVariable Long id){
        iClassSessionService.deleteClassSession(id);
        return ResponseEntity.noContent().build();
    }
}
