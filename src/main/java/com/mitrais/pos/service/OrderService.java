package com.mitrais.pos.service;

import com.mitrais.pos.entity.Order;
import com.mitrais.pos.model.request.OrderRequest;
import com.mitrais.pos.model.request.ProcessRequest;
import com.mitrais.pos.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> viewOrder(String status);

    Order createOrder(OrderRequest request) throws Exception;

    Order processOrder(Long id, ProcessRequest request) throws Exception;

}
