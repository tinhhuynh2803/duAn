package com.example.demo.controller;

import com.example.demo.model.Schedule;
import com.example.demo.service.IClassRoomService;
import com.example.demo.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private IScheduleService iScheduleService;

    @GetMapping
    public List<Schedule> getAllScheduleById(){
        return iScheduleService.getAllSchedule();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id){
        Schedule schedule = iScheduleService.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule){
        Schedule existingSchedule = iScheduleService.createSchedule(schedule);
        return ResponseEntity.ok(existingSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule){
        Schedule existingSchedule = iScheduleService.updateSchedule(id, schedule);
        return ResponseEntity.ok(existingSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable Long id){
        iScheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

}
