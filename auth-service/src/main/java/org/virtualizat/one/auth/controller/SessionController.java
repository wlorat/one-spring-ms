package org.virtualizat.one.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.virtualizat.one.auth.entity.Session;
import org.virtualizat.one.auth.service.SessionService;

import java.util.List;

@RestController
@RequestMapping(value="/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;
    @PostMapping(value="createSession")
    public ResponseEntity<Session> createUser(@RequestBody Session session){
        Session sessionCreate = sessionService.createSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessionCreate);
    }
    @GetMapping(value="listSession")
    public ResponseEntity<List<Session>> listUser(){
        List<Session> sessions = sessionService.listAllSession();
        if(sessions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(sessions);
    }
}
