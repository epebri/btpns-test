package com.mitrais.pos.service.impl;

import com.mitrais.pos.entity.User;
import com.mitrais.pos.model.en.Role;
import com.mitrais.pos.repository.UserRepository;
import com.mitrais.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getUserById(Long id, Role role) {
        return userRepository.findByIdAndRole(id, role.name());
    }
}
