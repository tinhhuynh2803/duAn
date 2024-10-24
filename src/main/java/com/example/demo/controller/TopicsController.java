package com.example.demo.controller;

import com.example.demo.model.Topics;
import com.example.demo.service.ITopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép yêu cầu từ nguồn này
public class TopicsController {

    @Autowired
    private ITopicsService iTopicsService;

    @GetMapping
    public List<Topics> getAllSubject(){
        return iTopicsService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topics> getSubjectById(@PathVariable Long id){
        Topics subject = iTopicsService.getTopicByID(id);
        return ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<Topics> createSubject(@RequestBody Topics subject){
        Topics subject1 = iTopicsService.createTopic(subject);
        return ResponseEntity.ok(subject1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topics> updateSubject(@PathVariable Long id, @RequestBody Topics subject){
        Topics subject1 = iTopicsService.updateTopic(id, subject);
        return ResponseEntity.ok(subject1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topics> deleteSubject(@PathVariable Long id){
        iTopicsService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
