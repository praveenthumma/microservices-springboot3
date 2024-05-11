package com.tp.ms.orderservice.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.tp.ms.orderservice.dto.OrderRequest;
import com.tp.ms.orderservice.model.Order;
import com.tp.ms.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // Business logic to place an order

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString()); 
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);


    }

}
