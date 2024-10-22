package com.example.demo.controller;

import com.example.demo.model.Attendance;
import com.example.demo.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private IAttendanceService iAttendanceService;

    @GetMapping
    public List<Attendance> getAllAttendance(){
        return iAttendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id){
        Attendance attendance = iAttendanceService.getAttendanceById(id);
        return ResponseEntity.ok(attendance);
    }

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance){
        Attendance createAttendance = iAttendanceService.createAttendance(attendance);
        return ResponseEntity.ok(attendance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance){
        Attendance updateAttendance = iAttendanceService.updateAttendance(id, attendance);
        return ResponseEntity.ok(attendance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Attendance> deleteAttendance(@PathVariable Long id){
        iAttendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
