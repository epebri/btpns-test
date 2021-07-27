package com.mitrais.pos.service;

import com.mitrais.pos.entity.User;
import com.mitrais.pos.model.en.Role;
import com.mitrais.pos.repository.UserRepository;
import com.mitrais.pos.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUserWithChefRoleTest() {
        Mockito.when(userRepository.findByIdAndRole(1L, Role.CHEF.name()))
                .thenReturn(Optional.of(new User(1L, "chef", "CHEF")));

        Optional<User> user = userService.getUserById(1L, Role.CHEF);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(1L, user.get().getId());
    }

    @Test
    public void getUserWithWaiterRoleTest() {
        Mockito.when(userRepository.findByIdAndRole(2L, Role.WAITER.name()))
                .thenReturn(Optional.of(new User(2L, "chef", "WAITER")));

        Optional<User> user = userService.getUserById(2L, Role.WAITER);

        Assertions.assertNotNull(user);
        Assertions.assertEquals(2L, user.get().getId());
    }
}