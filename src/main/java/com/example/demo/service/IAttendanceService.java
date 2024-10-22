package com.example.demo.service;

import com.example.demo.model.Attendance;

import java.util.List;

public interface IAttendanceService {

    public List<Attendance> getAllAttendance();
    public Attendance getAttendanceById(Long id);
    public Attendance createAttendance(Attendance attendance);
    public Attendance updateAttendance(Long id, Attendance attendance);
    public void deleteAttendance(Long id);
}
