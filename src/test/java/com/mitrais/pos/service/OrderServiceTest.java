package com.mitrais.pos.service;

import com.mitrais.pos.entity.Menu;
import com.mitrais.pos.entity.Order;
import com.mitrais.pos.entity.User;
import com.mitrais.pos.model.en.Role;
import com.mitrais.pos.model.en.Status;
import com.mitrais.pos.model.request.OrderRequest;
import com.mitrais.pos.model.request.ProcessRequest;
import com.mitrais.pos.model.response.OrderResponse;
import com.mitrais.pos.repository.OrderRepository;
import com.mitrais.pos.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @InjectMocks
    private OrderService orderService = new OrderServiceImpl();

    @Mock
    private UserService userService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private MenuService menuService;

    @Test
    void viewOrderByStatusTest() {
        List<OrderResponse> orderResponses = new ArrayList<>();
        orderResponses.add(OrderResponse.builder().id(1L).status(Status.CREATED.name()).chefId(1L).chefName("chef").menuId(1L).build());

        Mockito.when(orderRepository.findByStatus(Status.CREATED.name()))
                .thenReturn(orderResponses);

        List<OrderResponse> orders = orderService.viewOrder(Status.CREATED.name());

        Assertions.assertEquals(Status.CREATED.name(), orders.get(0).getStatus());
    }

    @Test
    void createOrderTest() throws Exception {
        Order order = new Order();
        order.setTableNo("D26");
        order.setStatus(Status.CREATED.name());
        order.setTotal(1L);
        order.setPrice(1000L);
        order.setTotalPrice(1000L);
        order.setMenuId(1L);
        order.setMenuName("Nasi goreng");
        order.setChefId(1L);
        order.setWaiterId(2L);

        Mockito.when(userService.getUserById(1L, Role.CHEF))
                .thenReturn(Optional.of(new User(1L, "chef", Role.CHEF.name())));

        Mockito.when(userService.getUserById(2L, Role.WAITER))
                .thenReturn(Optional.of(new User(2L, "waiter", Role.WAITER.name())));

        Mockito.when(menuService.getMenuById(1L))
                .thenReturn(Optional.of(new Menu(1L, "Nasi goreng", "F", "MAIN", 1000L)));

        Order savedData = new Order();
        savedData.setId(1L);
        savedData.setTableNo("D26");
        savedData.setStatus(Status.CREATED.name());
        savedData.setTotal(1L);
        savedData.setPrice(1000L);
        savedData.setTotalPrice(1000L);
        savedData.setMenuId(1L);
        savedData.setMenuName("Nasi goreng");
        savedData.setChefId(1L);
        savedData.setWaiterId(2L);

        Mockito.when(orderRepository.save(order))
                .thenReturn(savedData);


        Order response = orderService.createOrder(new OrderRequest("D26", 1L, 1L, 1L, 2L));

        Assertions.assertEquals(Status.CREATED.name(), response.getStatus());
    }

    @Test
    void processOrderTest() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setTableNo("D26");
        order.setStatus(Status.CREATED.name());
        order.setTotal(1L);
        order.setPrice(1000L);
        order.setTotalPrice(1000L);
        order.setMenuId(1L);
        order.setChefId(1L);
        order.setWaiterId(2L);

        Mockito.when(orderRepository.getById(1L))
                .thenReturn(order);

        Order updateData = new Order();
        updateData.setId(1L);
        updateData.setTableNo("D26");
        updateData.setStatus(Status.CREATED.name());
        updateData.setTotal(1L);
        updateData.setPrice(1000L);
        updateData.setTotalPrice(1000L);
        updateData.setMenuId(1L);
        updateData.setChefId(1L);
        updateData.setWaiterId(2L);;
        updateData.setStatus(Status.PROCESS.name());

        Mockito.when(orderRepository.save(updateData))
                .thenReturn(updateData);

        Mockito.when(userService.getUserById(1L, Role.CHEF))
                .thenReturn(Optional.of(new User(1L, "chef", Role.CHEF.name())));

        Order response = orderService.processOrder(1L, new ProcessRequest(1L));

        Assertions.assertEquals(Status.PROCESS.name(), response.getStatus());
    }
}