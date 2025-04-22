package com.example.orderservice.controller;
import com.example.orderservice.dtos.request.OrderRequest;
import com.example.orderservice.dtos.response.OrderResponse;
import com.example.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/orderapi")
public class OrderController {
    public static OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
    @PostMapping("createOrderWithClientAndDriver/{clientId}/{driverId}")
    public  OrderResponse createOrderWithClientAndDriver(@RequestBody OrderRequest orderRequest, @PathVariable Long clientId, @PathVariable Long driverId) {
        return  orderService.createOrderWithClientAndDriver(orderRequest,driverId,clientId)  ;   }
    @GetMapping("/getAllOrders")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrder();
    }

    @GetMapping("/orderById/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/updateOrder/{id}")
    public OrderResponse updateClient(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        return orderService.upDateOrder(orderRequest, id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public HashMap<String, String> deleteOrderById(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}