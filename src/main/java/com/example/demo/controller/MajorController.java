package com.example.demo.controller;

import com.example.demo.model.Major;
import com.example.demo.service.IMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/major")
public class MajorController {

    @Autowired
    private IMajorService iMajorService;

    @GetMapping
    public List<Major> getAllMajor(){
        return iMajorService.getAllMajor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Major> getMajorById(@PathVariable Long id){
        Major major = iMajorService.getMajorById(id);
        return ResponseEntity.ok(major);
    }

    @PostMapping
    public ResponseEntity<Major> createMajor(@RequestBody Major major){
        Major createMajor = iMajorService.createMajor(major);
        return ResponseEntity.ok(createMajor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Major> updateMajor(@PathVariable Long id, @RequestBody Major major){
        Major updateMajor = iMajorService.updateMajor(id, major);
        return ResponseEntity.ok(updateMajor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Major> deleteMajor(@PathVariable Long id){
        iMajorService.deleteMajor(id);
        return ResponseEntity.noContent().build();
    }
}
