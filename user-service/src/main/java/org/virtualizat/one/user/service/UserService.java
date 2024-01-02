package org.virtualizat.one.user.service;

import org.virtualizat.one.user.entity.User;
import org.virtualizat.one.user.entity.enums.State;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> listAllUser();
    public User getUser(UUID id);

    public User createUser(User user);
    public User updateUser(User user);
    public User deleteUser(User user);
    public List<User> findByState(State state);
}
