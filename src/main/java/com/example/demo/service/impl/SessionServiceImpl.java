package com.example.demo.service.impl;

import com.example.demo.model.Session;
import com.example.demo.repository.SessionRepository;
import com.example.demo.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElseThrow();
    }

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Long id, Session session) {
        Session existingSession = sessionRepository.findById(id).orElseThrow();
        existingSession.setTimeSlot(session.getTimeSlot());
        existingSession.setSessionName(session.getSessionName());
        return sessionRepository.save(existingSession);
    }

    @Override
    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}