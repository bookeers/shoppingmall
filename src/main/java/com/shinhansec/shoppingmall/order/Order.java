package com.shinhansec.shoppingmall.order;

import com.shinhansec.shoppingmall.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Order {
    int id;
    int count;
    Product product;

    public Order(Product orderdProduct, int count) {

        this.product = orderdProduct;
        this.count = count;
    }
}
