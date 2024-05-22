package com.shinhansec.shoppingmall.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private String description;
    private int categoryId;
}