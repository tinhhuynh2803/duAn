package com.example.demo.controller;

import com.example.demo.model.ClassSchedule;
import com.example.demo.service.IClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ClassScheduleController {

    @Autowired
    private IClassScheduleService iClassScheduleService;

    @GetMapping
    public List<ClassSchedule> getAllScheduleById(){
        return iClassScheduleService.getAllClassSchedule();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSchedule> getScheduleById(@PathVariable Long id){
        ClassSchedule classSchedule = iClassScheduleService.getClassScheduleById(id);
        return ResponseEntity.ok(classSchedule);
    }

    @PostMapping
    public ResponseEntity<ClassSchedule> createSchedule(@RequestBody ClassSchedule classSchedule){
        ClassSchedule existingClassSchedule = iClassScheduleService.createClassSchedule(classSchedule);
        return ResponseEntity.ok(existingClassSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSchedule> updateSchedule(@PathVariable Long id, @RequestBody ClassSchedule classSchedule){
        ClassSchedule existingClassSchedule = iClassScheduleService.updateClassSchedule(id, classSchedule);
        return ResponseEntity.ok(existingClassSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassSchedule> deleteSchedule(@PathVariable Long id){
        iClassScheduleService.deleteClassSchedule(id);
        return ResponseEntity.noContent().build();
    }

}
