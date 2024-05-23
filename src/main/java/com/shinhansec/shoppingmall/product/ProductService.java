package com.shinhansec.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDTO registerProduct(ProductDTO productDTO) {

        if (productRepository.findByName(productDTO.getName()).isPresent()) {

            throw new IllegalArgumentException("상품 이름이 중복됩니다: " + productDTO.getName());
        }

        Product product = new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice(),
                productDTO.getDescription(), productDTO.getCategoryId());

        Product savedProduct = productRepository.save(product);
        return savedProduct.toDTO();
    }

    public ProductDTO findProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(Product::toDTO).orElse(null);
    }

    public List<ProductDTO> findProducts(int limit, int currentPage) {
        int offset = (currentPage - 1) * limit;
        return productRepository.findAll().stream()
                .skip(offset).limit(limit).map(Product::toDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> findProducts(int limit, int currentPage, int categoryId) {
        int offset = (currentPage - 1) * limit;
        return productRepository.findByCategoryId(categoryId).stream()
                .skip(offset).limit(limit).map(Product::toDTO).collect(Collectors.toList());
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteAllById(productIds);
    }
}
