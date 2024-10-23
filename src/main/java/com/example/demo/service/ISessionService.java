package com.example.demo.service;

import com.example.demo.model.Session;

import java.util.List;

public interface ISessionService {
    List<Session> getAllSessions();
    Session getSessionById(Long id);
    Session createSession(Session session);
    Session updateSession(Long id, Session session);
    void deleteSession(Long id);
}
