package com.example.demo.service;

import com.example.demo.model.Schedule;
import com.example.demo.model.Subject;

import java.util.List;

public interface IScheduleService {
    public List<Schedule> getAllSchedule();
    public Schedule getScheduleById(Long id);
    public Schedule createSchedule(Schedule schedule);
    public Schedule updateSchedule(Long id, Schedule schedule);
    public void deleteSchedule(Long id);
}
