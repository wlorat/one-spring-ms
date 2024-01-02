package org.virtualizat.one.auth.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.virtualizat.one.auth.entity.Session;
import org.virtualizat.one.auth.entity.enums.State;


public interface SessionRepository extends JpaRepository<Session, UUID>{
    public List<Session> findByState(State state);
}
