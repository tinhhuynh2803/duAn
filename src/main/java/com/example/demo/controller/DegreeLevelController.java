package com.example.demo.controller;

import com.example.demo.model.DegreeLevel;
import com.example.demo.service.IDegreeLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/degreelevel")
public class DegreeLevelController {

    @Autowired
    private IDegreeLevelService iDegreeLevelService;

    @GetMapping
    public List<DegreeLevel> getAllDegreeLevel(){
        return iDegreeLevelService.getAllDegreeLevel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DegreeLevel> getDegreeLevelById(@PathVariable Long id){
        DegreeLevel degreeLevel = iDegreeLevelService.getDegreeLevelById(id);
        return ResponseEntity.ok(degreeLevel);
    }

    @PostMapping
    public ResponseEntity<DegreeLevel> createDegreeLevel(@RequestBody DegreeLevel degreeLevel){
        DegreeLevel createDegreeLevel = iDegreeLevelService.createDegreeLevel(degreeLevel);
        return ResponseEntity.ok(createDegreeLevel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DegreeLevel> updateDegreeLevel(@PathVariable Long id, @RequestBody DegreeLevel degreeLevel){
        DegreeLevel updateDegreeLevel = iDegreeLevelService.updateDegreeLevel(id, degreeLevel);
        return ResponseEntity.ok(updateDegreeLevel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DegreeLevel> deleteDegreeLevel(@PathVariable Long id){
        iDegreeLevelService.deleteDegreeLevel(id);
        return ResponseEntity.noContent().build();
    }
}
