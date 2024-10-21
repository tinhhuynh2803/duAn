package com.example.demo.service;

import com.example.demo.model.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> getAllClassRooms();
    ClassRoom getClassRoomById(Long id);
    ClassRoom createClassRoom(ClassRoom classRoom);
    ClassRoom updateClassRoom(Long id, ClassRoom classRoom);
    void deleteClassRoom(Long id);
}
