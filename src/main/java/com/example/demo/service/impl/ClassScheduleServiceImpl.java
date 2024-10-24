package com.example.demo.service.impl;

import com.example.demo.model.ClassSchedule;
import com.example.demo.repository.ClassScheduleRepository;
import com.example.demo.service.IClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassScheduleServiceImpl implements IClassScheduleService {

    @Autowired
    private ClassScheduleRepository classScheduleRepository;

    @Override
    public List<ClassSchedule> getAllClassSchedule() {
        return classScheduleRepository.findAll();
    }

    @Override
    public ClassSchedule getClassScheduleById(Long id) {
        return classScheduleRepository.findById(id).orElseThrow();
    }

    @Override
    public ClassSchedule createClassSchedule(ClassSchedule classSchedule) {

        return classScheduleRepository.save(classSchedule);
    }

    @Override
    public ClassSchedule updateClassSchedule(Long id, ClassSchedule classSchedule) {
        ClassSchedule classSchedule1 = classScheduleRepository.findById(id).orElseThrow();
        classSchedule1.setClassDate(classSchedule.getClassDate());
        classSchedule1.setStartTime(classSchedule.getStartTime());
        classSchedule1.setEndTime(classSchedule.getEndTime());
        return classScheduleRepository.save(classSchedule1);
    }

    @Override
    public void deleteClassSchedule(Long id) {
        classScheduleRepository.deleteById(id);
    }
}
