package com.mitrais.pos.service;

import com.mitrais.pos.entity.Order;
import com.mitrais.pos.entity.User;
import com.mitrais.pos.model.en.Role;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id, Role role);
    List<Order> showOrder();
}
