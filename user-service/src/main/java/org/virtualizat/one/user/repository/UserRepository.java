package org.virtualizat.one.user.repository;

import java.util.List;
import java.util.UUID;
import org.virtualizat.one.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.virtualizat.one.user.entity.enums.State;

public interface UserRepository extends JpaRepository<User, UUID>{
    public List<User> findByState(State state);
}
