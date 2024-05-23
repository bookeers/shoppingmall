package com.shinhansec.shoppingmall.product;
import com.shinhansec.shoppingmall.utils.ApiUtils;
import com.shinhansec.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ApiUtils.ApiResult<ProductDTO>> registerProduct(@RequestBody ProductDTO productDTO) {
        try {
            if (Validator.isAlpha(productDTO.getName()) && Validator.isNumber(productDTO.getPrice())) {
                log.info(productDTO.getName());

                ProductDTO savedProduct = productService.registerProduct(productDTO);

                try {
                    log.info(savedProduct.getName());
                } catch (NullPointerException e) {
                    return new ResponseEntity<>(ApiUtils.error(null, "서버 오류", HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
                }

                return new ResponseEntity<>(ApiUtils.success(savedProduct), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(ApiUtils.error(null, "잘못된 입력 값입니다.", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(ApiUtils.error(null, e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> findProduct(@PathVariable("id") int id) {
        if (!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ProductDTO resultProduct = productService.findProduct(id);

        if (resultProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(resultProduct, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> findProducts(
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        List<ProductDTO> products = (categoryId == null) ? productService.findProducts(limit, currentPage)
                : productService.findProducts(limit, currentPage, categoryId);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        if (!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProduct(id);
        ProductDTO product = productService.findProduct(id);

        return product == null ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/products/delete")
    public ResponseEntity<Void> deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
        List<Integer> productIds = deleteRequest.get("productIds");

        if (productIds.isEmpty()) {
            log.info("상품 ID가 없습니다.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
