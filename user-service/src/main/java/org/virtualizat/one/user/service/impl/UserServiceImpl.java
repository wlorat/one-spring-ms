package org.virtualizat.one.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtualizat.one.user.entity.User;
import org.virtualizat.one.user.entity.enums.State;
import org.virtualizat.one.user.repository.UserRepository;
import org.virtualizat.one.user.service.UserService;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setState(State.CREATED);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userDB = getUser(user.getId());
        if (null == userDB) {
            return null;
        }
        userDB.setUsername(user.getUsername());
        userDB.setHashtag(user.getHashtag());
        return userRepository.save(userDB);
    }

    @Override
    public User deleteUser(User user) {
        User userDB = getUser(user.getId());
        if (null == userDB) {
            return null;
        }
        userDB.setState(State.DELETED);
        return userRepository.save(userDB);
    }

    @Override
    public List<User> findByState(State state) {
        return userRepository.findByState(state);
    }


}
