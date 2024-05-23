package com.shinhansec.shoppingmall.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String description;
    private int categoryId;

    public Product() {
    }

    public Product(int id, String name, int price, String description, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDTO toDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.id);
        productDTO.setName(this.name);
        productDTO.setPrice(this.price);
        productDTO.setDescription(this.description);
        productDTO.setCategoryId(this.categoryId);
        return productDTO;
    }
}
