package com.example.demo.service.impl;

import com.example.demo.model.Attendance;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.service.IAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElseThrow();
    }

    @Override
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElseThrow();
        existingAttendance.setDateOfRecognition(attendance.getDateOfRecognition());
        existingAttendance.setNote(attendance.getNote());
        return attendanceRepository.save(existingAttendance);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
