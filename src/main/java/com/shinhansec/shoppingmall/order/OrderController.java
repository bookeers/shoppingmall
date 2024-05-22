package com.shinhansec.shoppingmall.order;

import com.shinhansec.shoppingmall.product.Product;
import com.shinhansec.shoppingmall.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderController {
    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public void orderProduct(@RequestBody OrderDTO orderDto) {

        Product orderdProduct = productService.findProduct(orderDto.getProductId());

        Order requestOrder = new Order(
                orderdProduct, orderDto.getCount()

        );

        orderService.orderProduct(requestOrder);
    }

    // 주문 개별 조회

    // 주문 전체 조회
}
