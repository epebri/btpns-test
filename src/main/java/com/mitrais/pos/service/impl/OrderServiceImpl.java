package com.mitrais.pos.service.impl;

import com.mitrais.pos.entity.Menu;
import com.mitrais.pos.entity.Order;
import com.mitrais.pos.entity.User;
import com.mitrais.pos.model.en.Role;
import com.mitrais.pos.model.en.Status;
import com.mitrais.pos.model.request.OrderRequest;
import com.mitrais.pos.model.request.ProcessRequest;
import com.mitrais.pos.model.response.OrderResponse;
import com.mitrais.pos.repository.OrderRepository;
import com.mitrais.pos.service.MenuService;
import com.mitrais.pos.service.OrderService;
import com.mitrais.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;

    @Override
    public List<OrderResponse> viewOrder(String status) {
        if (status != null) {
            return orderRepository.findByStatus(status);
        } else {
            return orderRepository.getAllData();
        }

    }

    @Override
    public Order createOrder(OrderRequest request) throws Exception {
        Order order = new Order();
        order.setTotal(request.getTotal());
        Optional<User> chef = userService.getUserById(request.getChefId(), Role.CHEF);
        if (chef.isPresent()) {
            order.setChefId(chef.get().getId());
        } else {
            throw new Exception("Chef id not valid");
        }

        Optional<User> waiter = userService.getUserById(request.getWaiterId(), Role.WAITER);
        if (waiter.isPresent()) {
            order.setWaiterId(waiter.get().getId());
        } else {
            throw new Exception("Waiter id not valid");
        }
        Optional<Menu> menu = menuService.getMenuById(request.getMenuId());
        if (menu.isPresent()) {
            order.setMenuId(menu.get().getId());
            order.setMenuName(menu.get().getName());
            order.setPrice(menu.get().getPrice());
            order.setTotalPrice(request.getTotal() * menu.get().getPrice());
        } else {
            throw new Exception("Menu id not valid");
        }
        order.setStatus(Status.CREATED.name());
        order.setTableNo(request.getTableNo());

        return orderRepository.save(order);
    }

    @Override
    public Order processOrder(Long id, ProcessRequest request) throws Exception {
        Order order = orderRepository.getById(id);
        if (order.getStatus().equals(Status.CREATED.name())) {
            Optional<User> chef = userService.getUserById(request.getUserId(), Role.CHEF);
            if (chef.isPresent()) {
                order.setStatus(Status.PROCESS.name());
            } else {
                throw new Exception("Process order failed");
            }
        } else if (order.getStatus().equals(Status.PROCESS.name())) {
            Optional<User> chef = userService.getUserById(request.getUserId(), Role.CHEF);
            if (chef.isPresent()) {
                order.setStatus(Status.SERVED.name());
            } else {
                throw new Exception("Process order failed");
            }
        } else if (order.getStatus().equals(Status.SERVED.name())) {
            Optional<User> waiter = userService.getUserById(request.getUserId(), Role.WAITER);
            if (waiter.isPresent()) {
                order.setStatus(Status.CLOSED.name());
            } else {
                throw new Exception("Process order failed");
            }
        } else {
            throw new Exception("Process order failed");
        }

        return orderRepository.save(order);
    }

}
