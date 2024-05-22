package com.shinhansec.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product registerProduct(Product product) {

        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findProducts(int limit, int currentPage) {
        int offset = (currentPage - 1) * limit;
        return productRepository.findAll().stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
        int offset = (currentPage - 1) * limit;
        return productRepository.findByCategoryId(categoryId).stream().skip(offset)
                .limit(limit).collect(Collectors.toList());
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteAllById(productIds);
    }
}