package org.virtualizat.one.auth.service;

import org.virtualizat.one.auth.entity.Session;
import org.virtualizat.one.auth.entity.enums.State;

import java.util.List;
import java.util.UUID;

public interface SessionService {
    List<Session> listAllSession();
    public Session getSession(UUID id);

    public Session createSession(Session session);
    public Session updateSession(Session session);
    public Session deleteSession(Session session);
    public List<Session> findByState(State state);
}
