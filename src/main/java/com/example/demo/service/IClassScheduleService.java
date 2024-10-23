package com.example.demo.service;

import com.example.demo.model.ClassSchedule;

import java.util.List;

public interface IClassScheduleService {
    public List<ClassSchedule> getAllClassSchedule();
    public ClassSchedule getClassScheduleById(Long id);
    public ClassSchedule createClassSchedule(ClassSchedule classSchedule);
    public ClassSchedule updateClassSchedule(Long id, ClassSchedule classSchedule);
    public void deleteClassSchedule(Long id);
}
