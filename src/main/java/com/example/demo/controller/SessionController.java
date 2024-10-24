package com.example.demo.controller;

import com.example.demo.model.Session;
import com.example.demo.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private ISessionService iSessionService;

    @GetMapping
    public List<Session> getAllSession(){
        return iSessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id){
        Session session = iSessionService.getSessionById(id);
        return ResponseEntity.ok(session);
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody Session session){
        Session createSession = iSessionService.createSession(session);
        return ResponseEntity.ok(createSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(@PathVariable Long id, @RequestBody Session session){
        Session updateSession = iSessionService.updateSession(id, session);
        return ResponseEntity.ok(updateSession);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Session> deleteSession(@PathVariable Long id){
        iSessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
