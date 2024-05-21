package com.shinhansec.shoppingmall.order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;
    public void orderProduct(Order order) {

        orderRepository.saveOrder(order);
    }
}
