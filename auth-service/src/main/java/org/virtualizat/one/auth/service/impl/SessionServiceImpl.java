package org.virtualizat.one.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtualizat.one.auth.entity.Session;
import org.virtualizat.one.auth.entity.enums.State;
import org.virtualizat.one.auth.repository.SessionRepository;
import org.virtualizat.one.auth.service.SessionService;

import java.util.List;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionRepository sessionRepository;

    @Override
    public List<Session> listAllSession() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getSession(UUID id) {
        return sessionRepository.findById(id).orElse(null);
    }

    @Override
    public Session createSession(Session session) {
        session.setState(State.INICIALIZATED);
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Session session) {
        Session sessionDB = getSession(session.getId());
        if (null == sessionDB) {
            return null;
        }
        sessionDB.setState(session.getState());
        return sessionRepository.save(sessionDB);
    }

    @Override
    public Session deleteSession(Session session) {
        if (null == session) {
            return null;
        }
        sessionRepository.delete(session);
        return session;
    }

    @Override
    public List<Session> findByState(State state) {
        return sessionRepository.findByState(state);
    }
}
