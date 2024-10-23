package com.example.demo.controller;

import com.example.demo.model.TuitionFee;
import com.example.demo.service.ITuitionFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registercourse")
public class TuitionFeeController {

    @Autowired
    private ITuitionFeeService iTuitionFeeService;

    @GetMapping
    public List<TuitionFee> getAllTuitionFee(){
        return iTuitionFeeService.getAllTuitionFee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TuitionFee> getTuitionFeeById(@PathVariable Long id){
        TuitionFee tuitionFee = iTuitionFeeService.getTuitionFeeById(id);
        return ResponseEntity.ok(tuitionFee);
    }

    @PostMapping
    public ResponseEntity<TuitionFee> createTuitionFee(@RequestBody TuitionFee tuitionFee){
        TuitionFee createTuitionFee = iTuitionFeeService.createTuitionFee(tuitionFee);
        return ResponseEntity.ok(createTuitionFee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuitionFee> updateTuitionFee(@PathVariable Long id, @RequestBody TuitionFee tuitionFee){
        TuitionFee updateTuitionFee = iTuitionFeeService.updateTuitionFee(id, tuitionFee);
        return ResponseEntity.ok(updateTuitionFee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TuitionFee> deleteTuitionFee(@PathVariable Long id){
        iTuitionFeeService.deleteTuitionFee(id);
        return ResponseEntity.noContent().build();
    }
}
