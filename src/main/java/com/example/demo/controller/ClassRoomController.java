package com.example.demo.controller;

import com.example.demo.model.ClassRoom;
import com.example.demo.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classroom")
public class ClassRoomController {

    @Autowired
    private IClassRoomService iClassRoomService;

    @GetMapping
    public List<ClassRoom> getAllClassRoom(){
        return iClassRoomService.getAllClassRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> getClassRoomById(@PathVariable Long id){
        ClassRoom classRoom = iClassRoomService.getClassRoomById(id);
        return ResponseEntity.ok(classRoom);
    }

    @PostMapping
    public ResponseEntity<ClassRoom> createClassRoom(@RequestBody ClassRoom classRoom){
        ClassRoom existingClassRoom = iClassRoomService.createClassRoom(classRoom);
        return ResponseEntity.ok(existingClassRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable Long id, @RequestBody ClassRoom classRoom){
        ClassRoom existingClassRoom = iClassRoomService.updateClassRoom(id, classRoom);
        return ResponseEntity.ok(existingClassRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassRoom> deleteClassRoom(@PathVariable Long id){
        iClassRoomService.deleteClassRoom(id);
        return ResponseEntity.noContent().build();
    }
}
