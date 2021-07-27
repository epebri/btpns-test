package com.mitrais.pos.service;

import com.mitrais.pos.entity.User;
import com.mitrais.pos.model.en.Role;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByIdAndRole(Long id, Role role);
}
