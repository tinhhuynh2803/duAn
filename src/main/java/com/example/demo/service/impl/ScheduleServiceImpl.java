package com.example.demo.service.impl;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow();
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {

        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Long id, Schedule schedule) {
        Schedule schedule1 = scheduleRepository.findById(id).orElseThrow();
        schedule1.setSchoolDay(schedule.getSchoolDay());
        schedule1.setStartTime(schedule.getStartTime());
        schedule1.setEndTime(schedule.getEndTime());
        return scheduleRepository.save(schedule1);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
