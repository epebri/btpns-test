package com.mitrais.pos.controller;

import com.mitrais.pos.entity.Order;
import com.mitrais.pos.model.request.OrderRequest;
import com.mitrais.pos.model.request.ProcessRequest;
import com.mitrais.pos.model.response.OrderResponse;
import com.mitrais.pos.model.response.ResponseHandler;
import com.mitrais.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<ResponseHandler> getAllMenus(@RequestParam(required = false) String status) {
        ResponseHandler response = new ResponseHandler();
        try {
            List<OrderResponse> orders = orderService.viewOrder(status);
            response.setCode(200L);
            response.setMessage("Get order success!");
            response.setData(orders);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(500L);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<ResponseHandler> createOrder(@RequestBody OrderRequest request) {
        ResponseHandler response = new ResponseHandler();
        try {
            Order order = orderService.createOrder(request);
            response.setCode(201L);
            response.setMessage("Order success created!");
            response.setData(order);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(500L);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/orders/{id}/process")
    public ResponseEntity<ResponseHandler> processOrder(@PathVariable("id") Long id, @RequestBody ProcessRequest request) {
        ResponseHandler response = new ResponseHandler();
        try {
            Order order = orderService.processOrder(id, request);
            response.setCode(200L);
            response.setMessage("Order success updated!");
            response.setData(order);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(500L);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
