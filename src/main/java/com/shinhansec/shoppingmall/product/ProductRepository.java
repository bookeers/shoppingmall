package com.shinhansec.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<>();
    int id = 0;

    public Product save(Product product) {

        product.setId(id++);

        productTable.put(product.getId(), product);
        System.out.println(productTable.get(id-1));

        return productTable.get(id-1);
    }

    public Product findProduct(int id) {

        return productTable.get(id);
    }

    public List<Product> findProducts(int limit, int currentPage) {

        return productTable.values().stream().toList();
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        return productTable.values().stream().filter(product -> product.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }

    public void deleteProduct(int id) {
        productTable.remove(id);
    }

    public void deleteProducts(List<Integer> productIds) {

        productIds.forEach(productTable::remove);
    }
}
