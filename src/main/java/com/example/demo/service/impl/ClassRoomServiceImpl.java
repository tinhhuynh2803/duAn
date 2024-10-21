package com.example.demo.service.impl;

import com.example.demo.model.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements IClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom getClassRoomById(Long id) {
        return classRoomRepository.findById(id).orElseThrow();
    }

    @Override
    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom updateClassRoom(Long id, ClassRoom classRoom) {
        ClassRoom existingClassRoom = classRoomRepository.findById(id).orElseThrow();
        existingClassRoom.setRoomName(classRoom.getRoomName());
        existingClassRoom.setNote(classRoom.getNote());
        return classRoomRepository.save(existingClassRoom);
    }

    @Override
    public void deleteClassRoom(Long id) {
        classRoomRepository.deleteById(id);
    }
}
