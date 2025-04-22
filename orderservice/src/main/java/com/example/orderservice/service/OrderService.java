package com.example.orderservice.service;
import com.example.orderservice.dtos.request.OrderRequest;
import com.example.orderservice.dtos.response.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse getOrder(Long id);
    List<OrderResponse> getAllOrder();
    OrderResponse upDateOrder(OrderRequest orderRequest , Long id);
    HashMap<String , String> deleteOrder(Long id);
    OrderResponse createOrderWithClientAndDriver(OrderRequest orderRequest, Long ClientId,Long driverId);

}